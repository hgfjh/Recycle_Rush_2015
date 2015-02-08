package org.usfirst.frc.team1923.robot.subsystems;

//import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;


import org.usfirst.frc.team1923.util.Calculator;

//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Relay;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	private static double SMOOTH_VALUE = 0.02;
	public double cWheels = 0;
	public boolean armsActivated = false;
	
	public IntakeSubsystem() {
		this.init();
	}

	public void init() {
	}


	public void initDefaultCommand() {
	}


	public void intakeWheelsIn(double speed) {
		cWheels = coalesce(speed, cWheels);
		RobotMap.intakeMotor.set(cWheels);
	}

	public void intakeWheelsOut(double speed) {
		cWheels = coalesce(-speed, cWheels);
		RobotMap.intakeMotor.set(cWheels);
	}
	
	public void armsIn(){
 		RobotMap.intakeSolenoidLeft.set(true); //TODO are these the correct boolean values?
		RobotMap.intakeSolenoidRight.set(false);
		armsActivated = true;
	}
	
	/**
	 * Makes the arms face outward (away from center of robot)
	 */
	public void armsOut(){
		RobotMap.intakeSolenoidLeft.set(false);
		RobotMap.intakeSolenoidRight.set(true);
		armsActivated = false;
	}

	public void setArms(boolean state){
		if(state) //true - arms in
			armsIn();
		else      //false - arms out
			armsOut();
	}
	/**
	 * Inverts the state of the arms
	 * Arms in -> Arms out etc..
	 */
	public void toggleArms(){
		if(armsActivated){
			this.armsOut();
		} else {
			this.armsIn();
		}
	}
	
	/**
	 * Coalesces the given current number to match the old number
	 * @param current the current number given from the input
	 * @param old the previous input
	 * @param smooth_value the value at which to coalesce at
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
		return Calculator.ease(current, old);
	}
	
	public void stop() {
		cWheels = 0;
		RobotMap.intakeMotor.set(cWheels);
	}
	
}
