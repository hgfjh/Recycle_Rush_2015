package org.usfirst.frc.team1923.robot.subsystems;

//import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;


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
public class BinArmSubsystem extends Subsystem {
	
	public boolean armsOut = false;
	
	public BinArmSubsystem() {
		this.init();
	}

	public void init() {
	}


	public void initDefaultCommand() {
		
	}
	
	public void armsIn(){
 		RobotMap.binSolenoidLeft.set(false);
		RobotMap.binSolenoidRight.set(true);
		armsOut = false;
	}
	
	public void armsOut(){
		RobotMap.binSolenoidLeft.set(true);
		RobotMap.binSolenoidRight.set(false);
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
