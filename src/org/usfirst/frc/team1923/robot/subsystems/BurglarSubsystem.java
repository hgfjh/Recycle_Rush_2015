package src.org.usfirst.frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import src.org.usfirst.frc.team1923.robot.RobotMap;

/**
 *
 */
public class BurglarSubsystem extends Subsystem {

	public boolean state;
	
    public void initDefaultCommand() {

    }
    
    public void set(double speed){
    	RobotMap.canGrabber1.set(speed);
    	RobotMap.canGrabber2.set(speed);
    }
    
    public void motorSpeed(double speed){
    	RobotMap.burglarTalon.set(speed);
    }

    
}

