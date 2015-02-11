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

	public double oldWheelSpeed = 0;
	public boolean armsActivated = false;
	
	public IntakeSubsystem() {
		this.init();
	}

	public void init() {
	}


	public void initDefaultCommand() {
	}


	public void intakeWheelsIn(double speed) {
		oldWheelSpeed = Calculator.ease(speed, oldWheelSpeed);
		RobotMap.intakeMotor.set(oldWheelSpeed);
	}

	public void intakeWheelsOut(double speed) {
		oldWheelSpeed = Calculator.ease(-speed, oldWheelSpeed);
		RobotMap.intakeMotor.set(oldWheelSpeed);
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
	
	public void stop() {
		oldWheelSpeed = 0;
		RobotMap.intakeMotor.set(oldWheelSpeed);
	}
	
}
