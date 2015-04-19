package org.usfirst.frc.team1923.robot.subsystems;

//import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class TuskSubsystem extends Subsystem {
	
	public boolean armsOut = false;
	
	public TuskSubsystem() {
		this.init();
	}

	public void init() {
	}


	public void initDefaultCommand() {
		
	}
	
	public void armsIn(){
 		RobotMap.tuskSolenoidLeft.set(false);
		RobotMap.tuskSolenoidRight.set(true);
		armsOut = false;
	}
	
	public void armsOut(){
		RobotMap.tuskSolenoidLeft.set(true);
		RobotMap.tuskSolenoidRight.set(false);
		armsOut = true;
	}

	public void toggle(){
		if(!armsOut){
			armsOut();
		} else if(armsOut) {
			armsIn();
		}
	}	
	
	public boolean getArms(){
		return armsOut;
	}
}
