package src.org.usfirst.frc.team1923.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import src.org.usfirst.frc.team1923.util.CustomDigitalInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static boolean ISGALILEO = false;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	// Constants
	public static double ELEVATOR_POSITION_0 = 0.0;
	public static double ELEVATOR_POSITION_1 = 17.5;
	public static double ELEVATOR_POSITION_2 = 30;
	public static double ELEVATOR_POSITION_3 = 49.0;
	public static double ELEVATOR_POSITION_COOP = 6.875;
	public static double ELEVATOR_POSITION_RC = 35.0;

	public static double DIST_TO_PICK_UP_TOTE = 27.25;
	public static double DIST_TO_NEXT_TOTE = 95.0;
	public static double DIST_TO_AUTON_ZONE = 125;
	
	public static final double ELEVATOR_UP_SPEED = 0.8;
	public static final double ELEVATOR_DOWN_SPEED = 0.7;
	public static final double EASE_INCREMENT = 0.05;

	// Compressor
	
	public static Compressor compressor = new Compressor(0);

	// Drive Train
	public static CANTalon frontLeftDrive = new CANTalon(0);
	public static CANTalon rearLeftDrive = new CANTalon(1);
	public static CANTalon frontRightDrive = new CANTalon(2);
	public static CANTalon rearRightDrive = new CANTalon(3);

	// CatWoman
	public static CANTalon canGrabber1 = new CANTalon(8);
	public static CANTalon canGrabber2 = new CANTalon(9);
	
	//tusks 
	public static Solenoid tuskSolenoidLeft = new Solenoid(4);
	public static Solenoid tuskSolenoidRight = new Solenoid(5);


	
	// Elevator
	public static CANTalon elevatorLeftMotor = new CANTalon(4);
	public static CANTalon elevatorRightMotor = new CANTalon(5);

	// Intake
	public static CANTalon intakeMotorLeft = new CANTalon(6);
	public static CANTalon intakeMotorRight = new CANTalon(7);
	
	public static Solenoid intakeSolenoidLeft = new Solenoid(0);
	public static Solenoid intakeSolenoidRight = new Solenoid(1);
	
	// burglar 
	public static CANTalon burglarTalon = new CANTalon(8);
	public static Solenoid burglarSolenoid = new Solenoid(0); // TODO get correct port
	
	public static Solenoid burglarIn = new Solenoid(3);
	public static Solenoid burglarOut = new Solenoid(2);
	

	// Sensors
	public static Encoder driveEncoderLeft = new Encoder(0, 1, false,
			EncodingType.k4X);
	public static Gyro gyro = new Gyro(0);
	public static Encoder driveEncoderRight = new Encoder(2, 3, true,
			EncodingType.k4X);
	public static AnalogInput temperature = new AnalogInput(2);
	public static Encoder elevatorEncoder = new Encoder(4, 5, true,
			EncodingType.k4X);

	// Digital IO
	public static DigitalInput elevatorTopLimitSwitch;
	public static DigitalInput elevatorBottomLimitSwitch;
	
	//Lights
	public static Relay WhiteLED = new Relay(0);
	public static Relay PinkLED = new Relay(1);
	public static Relay RedBlueLED = new Relay(2);


	// DriveTrain
	public static RobotDrive robotDriveTrain = new RobotDrive(frontLeftDrive,
			rearLeftDrive, frontRightDrive, rearRightDrive);

	// Elevator
	public static RobotDrive elevatorDrive = new RobotDrive(elevatorLeftMotor,
			elevatorRightMotor);


	

	// Motor Group for Drive
	/* Motor Group Init. */
	// public static final MotorGroup driveLeftSide = new
	// MotorGroup(frontLeftDrive, rearLeftDrive);
	// public static final MotorGroup driveRightSide = new
	// MotorGroup(frontRightDrive, rearRightDrive);

	// Robot system initialization
	public static void init() {
		compressor.setClosedLoopControl(true);
		gyro.reset();
		driveEncoderLeft.reset();
		driveEncoderRight.reset();
		elevatorEncoder.reset();
		//frontLeftDrive.setVoltageRampRate(SMOOTH_VALUE);
		//frontRightDrive.setVoltageRampRate(SMOOTH_VALUE);
		//rearLeftDrive.setVoltageRampRate(SMOOTH_VALUE);
		//rearRightDrive.setVoltageRampRate(SMOOTH_VALUE);

		// Test Mode --------------------
		// LiveWindow.addActuator("DriveTRainSubsystem", "frontLeftDrive",
		// (LiveWindowSendable) frontLeftDrive);
		// LiveWindow.addActuator("DriveTRainSubsystem", "rearLeftDrive",
		// (LiveWindowSendable) rearLeftDrive);
		// LiveWindow.addActuator("DriveTRainSubsystem", "frontRightDrive",
		// (LiveWindowSendable) frontRightDrive);
		// LiveWindow.addActuator("DriveTRainSubsystem", "rearRightDrive",
		// (LiveWindowSendable) rearRightDrive);
		// LiveWindow.addActuator("elevatorDrive", "elevatorLeftMotor",
		// (LiveWindowSendable) elevatorLeftMotor);
		// LiveWindow.addActuator("elevatorDrive", "elevatorRightMotor",
		// (LiveWindowSendable) elevatorRightMotor);

		// Live Window
		LiveWindow.addSensor("DriveTrainSubsystem", "Left Encoder",
				RobotMap.driveEncoderLeft);
		LiveWindow.addSensor("DriveTrainSubsystem", "Right Encoder",
				RobotMap.driveEncoderRight);
		LiveWindow.addSensor("DriveTrainSubsystem", "Gyro", RobotMap.gyro);
		LiveWindow.addSensor("ElevatorSubsystem", "Elevator Encoder",
				RobotMap.elevatorEncoder);


	}

}
