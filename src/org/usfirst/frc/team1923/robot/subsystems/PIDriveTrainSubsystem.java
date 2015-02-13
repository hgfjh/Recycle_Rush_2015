package org.usfirst.frc.team1923.robot.subsystems;

//import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;
import org.usfirst.frc.team1923.robot.commands.*;
import org.usfirst.frc.team1923.util.Calculator;

import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Gyro;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class PIDriveTrainSubsystem extends PIDSubsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	// distance per pulse of a drive-wheel encoder, in inches. [CHANGE THESE
	// VALUES!!!!!!!!!!]
	// Declare variable for the robot drive system
	// public RobotDrive robotDriveTrain = RobotMap.robotDriveTrain;
	private Timer timer;
	private double timeOut = 2.0;
	private int DRIVE_MODE = 1;
	public double oldLeftSpeed = 0;
	public double oldRightSpeed = 0;
	public double autoOldLeftSpeed = 0;
	public double autoOldRightSpeed = 0;
	public double corValue = 0.2;
	public double corValueNeg = 0.05;

	// Drive Wheel Encoders
	// private Encoder driveEncoderLeft = RobotMap.driveEncoderLeft;
	// private Encoder driveEncoderRight = RobotMap.driveEncoderRight;
	// gyro.
	// private Gyro gyro = RobotMap.gyro;

	private static final double NUM_CLICKS = 256, // distance per pulse = 0.0491"/pulse
			GEAR_RATIO = 1.0 / 1.0, 
			WHEEL_CIRCUMFERENCE = 12.56, // 4 inches wheels
			
			//LEAVE THESE CONSTANTS ALONE!
			Pg = 0.0118, 	Ig = 0.000,	 Dg = 0.0,
			Pe = 0.02, 	Ie = 0.000,	 De = 0.00, 
			
			PID_LOOP_TIME = .05,
			gyroTOLERANCE = 3, // 0.2778% error ~= 0.5 degrees...?
			encoderTOLERANCE = 2.0, // +/- 2" tolarance
			speedDiffGain = 0.05;

	private static final int MANUAL_MODE = 1, ENCODER_MODE = 2, GYRO_MODE = 3;

	public PIDriveTrainSubsystem() {
		super(Pe, Ie, De);
		// TODO
		// Set distance per pulse for each encoder
		RobotMap.driveEncoderLeft.setDistancePerPulse(GEAR_RATIO * WHEEL_CIRCUMFERENCE / NUM_CLICKS);
		RobotMap.driveEncoderRight.setDistancePerPulse(GEAR_RATIO * WHEEL_CIRCUMFERENCE / NUM_CLICKS);
		this.getPIDController().setPID(Pe, Ie, De);
		this.setAbsoluteTolerance(encoderTOLERANCE);
		this.setOutputRange(-1.0, 1.0);
		this.setInputRange(-200.0, 200.0);
		this.disable();
		RobotMap.gyro.reset();
		DRIVE_MODE = MANUAL_MODE;

		// Timer
		timer = new Timer();

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TeleopCommand());
	}

	// Manual Drive
	public void manualDrive(double x, double y) {
		this.disable();
		smoothDrive(x, y);
	}

	// Stop
	public void stop() {
		this.disable();
		oldLeftSpeed = 0;
		oldRightSpeed = 0;
		smoothDrive(0.0, 0.0);
	}

	// Drive Stright Distance Using Encoder
	public void driveStrightUsingEncoder(double dist, double maxTimeOut) {
		// TODO
		resetGyro();
		resetBothEncoders();
		
		setSetpoint(dist);
		setEncoderPID();

		this.timeOut = maxTimeOut;
		this.timer.reset();
		this.timer.start();
	}

	/**
	 * Use the left Encoder as the PID sensor. This method is automatically
	 * called by the subsystem.
	 */
	protected double returnPIDInput() {
		return sensorFeedback();
	}

	/**
	 * Use the robotDriveTrain as the PID output. This method is automatically
	 * called by the subsystem.
	 */
	protected void usePIDOutput(double d) {
		applyPIDOutput(d);
	}

	public boolean reachedTarget() {
		if (timer.get() > this.timeOut || this.onTarget()) {
			this.disable();
			DRIVE_MODE = MANUAL_MODE;
			timer.stop();
			timer.reset();
			return true;
		} else {
			return false;
		}

	}

	public double getDistanceError() {

		return this.getSetpoint() - this.getPosition();

	}

	/**
	 *
	 * @return Count from the encoder (since the last reset?).
	 */
	public double getLeftEncoderCount() {
		return RobotMap.driveEncoderLeft.getRaw();
	}

	public double getRightEncoderCount() {
		return RobotMap.driveEncoderRight.getRaw();
	}

	/**
	 *
	 * @return Distance the encoder has recorded since the last reset, adjusted
	 *         for the gear ratio.
	 */
	public double getLeftEncoderDistance() {
		return RobotMap.driveEncoderLeft.getDistance();
	}

	public double getRightEncoderDistance() {
		return RobotMap.driveEncoderRight.getDistance();
	}

	public double getAvgEncoderDistance() {
		return (RobotMap.driveEncoderLeft.getDistance() + RobotMap.driveEncoderRight
				.getDistance()) / 2.0;
	}

	public double getSpeedDiff() {
		return RobotMap.driveEncoderLeft.getRate()
				- RobotMap.driveEncoderRight.getRate();
	}

	// Gyro Base Turns
	public void turnRobotHeading(double angle, double maxTimeOut) {

		setGyroPID();

		setSetpoint(angle);

		this.timeOut = maxTimeOut;
		this.timer.reset();
		this.timer.start();

	}

	private void setEncoderPID() {
		// PID tolerance
		DRIVE_MODE = ENCODER_MODE;
		this.getPIDController().setPID(Pe, Ie, De);
		this.setAbsoluteTolerance(encoderTOLERANCE);
		this.setOutputRange(-1.0, 1.0);
		this.setInputRange(-200.0, 200.0);
		this.enable();

	}

	public void setGyroPID() {
		DRIVE_MODE = GYRO_MODE;
		this.resetGyro();
		this.getPIDController().setPID(Pg, Ig, Dg);
		this.setAbsoluteTolerance(gyroTOLERANCE);
		this.setOutputRange(-1.0, 1.0);
		this.setInputRange(-360.0, 360.0);
		this.enable();

	}

	private double sensorFeedback() {
		double sensorReading = 0.0;
		if (DRIVE_MODE == ENCODER_MODE) {
			sensorReading = getAvgEncoderDistance();
		} else if (DRIVE_MODE == GYRO_MODE) {
			sensorReading = RobotMap.gyro.getAngle();

		}

		return sensorReading;
	}

	private void applyPIDOutput(double d) {
		if (DRIVE_MODE == ENCODER_MODE) {
			autonStraightSmoothDrive(d, d);
		} else if (DRIVE_MODE == GYRO_MODE) {
			smoothDrive(d / 2.0, -d / 2.0);
		}

	}

	public void arcDrive(double speed, double curve) {
		// TODO
		// smoothDrive(speed, speed);
	}

	/**
	 * Coalesces the given current number to match the old number
	 * @param current the current number given from the input
	 * @param old the previous input
	 * @return the coalesced number
	 */

	public double getEasedLeft() {
		return oldLeftSpeed;
	}

	public double getEasedRight() {
		return oldRightSpeed;
	}

	
	public void smoothDrive(double left, double right){
		oldLeftSpeed = Calculator.ease(left, oldLeftSpeed);
		oldRightSpeed = Calculator.ease(right, oldRightSpeed);

		left = oldLeftSpeed;
		right = oldRightSpeed;
		

		if (left < 0.0 && Math.abs(left) > corValueNeg)
			left += corValueNeg;
		else if (left > 0.0 && left > corValue)
			left -= corValue; 
		else
			left = 0.0;
		RobotMap.robotDriveTrain.tankDrive(left, right, false);

	}
	
	public void autonStraightSmoothDrive(double left, double right){
		left = left - ((getSpeedDiff() / 2 ) * speedDiffGain );
		right = right + ((getSpeedDiff() / 2 ) * speedDiffGain );

		autoOldLeftSpeed = Calculator.ease(left, autoOldLeftSpeed);
		autoOldRightSpeed = Calculator.ease(right, autoOldRightSpeed);

		left = autoOldLeftSpeed;
		right = autoOldRightSpeed;
		
		RobotMap.robotDriveTrain.tankDrive(left, right, false);
	}

	public double getRobotHeading() {
		return RobotMap.gyro.getAngle();
	}
	public double getLeftSpeed(){
		return RobotMap.driveEncoderLeft.getRate();
	}
	
	public double getRightSpeed(){
		return RobotMap.driveEncoderRight.getRate();
	}

	public void resetBothEncoders() {
		RobotMap.driveEncoderLeft.reset();
		RobotMap.driveEncoderRight.reset();
	}

	public void resetGyro() {
		RobotMap.gyro.reset();
	}
}
