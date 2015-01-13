package org.usfirst.frc.team1923.robot.subsystems;



import org.usfirst.frc.team1923.robot.RobotMap;
import org.usfirst.frc.team1923.robot.commands.*;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoyStickCommand()); // TBD for Commandbased programming
    }
    
    // Manual Drive 
    public void manualDrive(double x, double y) {
        //disablePID();
        //mode = MANUAL_MODE;
    	RobotMap.robotDriveTrain.tankDrive(x, y);
        
        
    }
    
}

