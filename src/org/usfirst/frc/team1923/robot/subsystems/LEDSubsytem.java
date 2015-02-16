package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDSubsytem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public LEDSubsytem(){
		super();
		whiteLEDOn();
		pinkLEDOn();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void whiteLEDOn() {
		RobotMap.WhiteLED.set(Value.kForward);
	}

	public void pinkLEDOn() {
		RobotMap.PinkLED.set(Value.kForward);
	}
	
	public void redBlueLEDOn(boolean color) {
		if(color)
			RobotMap.RedBlueLED.set(Value.kForward);
		else
			RobotMap.RedBlueLED.set(Value.kReverse);	
	}
	
}