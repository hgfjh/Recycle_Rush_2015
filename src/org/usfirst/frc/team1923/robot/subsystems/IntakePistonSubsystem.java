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
public class IntakePistonSubsystem extends Subsystem {
	
	private boolean activated = false;
	
	public IntakePistonSubsystem() {
		this.init();
	}

	public void init() {
	}


	public void initDefaultCommand() {
	}
	
	public void activate(){
 		RobotMap.intakeSolenoidLeft.set(true);
		RobotMap.intakeSolenoidRight.set(false);
		activated = true;
	}
	
	public void deactivate(){
		RobotMap.intakeSolenoidLeft.set(false);
		RobotMap.intakeSolenoidRight.set(true);
		activated = false;
	}

	public void toggle(){
		if(activated){
			deactivate();
		} else {
			activate();
		}
	}	
}
