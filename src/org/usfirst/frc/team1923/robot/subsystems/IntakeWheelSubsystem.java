package src.org.usfirst.frc.team1923.robot.subsystems;

//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Relay;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import src.org.usfirst.frc.team1923.robot.RobotMap;

/**
 *
 */
public class IntakeWheelSubsystem extends Subsystem {

	private static double SMOOTH_VALUE = 0.20;
	public double cWheels = 0;
	
	public IntakeWheelSubsystem() {
		this.init();
	}

	public void init() {
	}


	public void initDefaultCommand() {
	}


	public void intakeWheelsIn(double speed) {
		cWheels = coalesce(speed, cWheels);
		RobotMap.intakeMotorLeft.set(-cWheels);
		RobotMap.intakeMotorRight.set(cWheels);
	}

	public void intakeWheelsOut(double speed) {
		cWheels = coalesce(speed, cWheels);
		RobotMap.intakeMotorLeft.set(cWheels);
		RobotMap.intakeMotorRight.set(-cWheels);
	}
	
	public void intakeWheelsLeft(double speed){
		cWheels = coalesce(speed, cWheels);
		RobotMap.intakeMotorLeft.set(cWheels);
		RobotMap.intakeMotorRight.set(cWheels);
	}
	
	public void intakeWheelsRight(double speed){
		cWheels = coalesce(speed, cWheels);
		RobotMap.intakeMotorLeft.set(-cWheels);
		RobotMap.intakeMotorRight.set(-cWheels);
	}
	
	/**
	 * Coalesces the given current number to match the old number
	 * @param current the current number given from the input
	 * @param old the previous input
	 * @return the coalesced number
	 */
	private double coalesce(double current, double old, double smooth_value) {
		if (current < old - SMOOTH_VALUE) {
			current = old - SMOOTH_VALUE;
		} else if (current > old + SMOOTH_VALUE) {
			current = old + SMOOTH_VALUE;
		} else {
			current = old;
		}
	
		return current;
	}
	
	private double coalesce(double current, double old){
		return coalesce(current, old, SMOOTH_VALUE);
	}
	
	public void stop() {
		cWheels = 0;
		RobotMap.intakeMotorLeft.set(cWheels);
		RobotMap.intakeMotorRight.set(cWheels);
	}
	
}
