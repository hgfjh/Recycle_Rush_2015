package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void moveElevatorUp(double speed) {
        //disablePID();
        //mode = MANUAL_MODE;
    	RobotMap.elevatorDrive.tankDrive(speed, speed);
        
        
    }
    
    public void moveElevatorDown(double speed) {
        //disablePID();
        //mode = MANUAL_MODE;
    	RobotMap.elevatorDrive.tankDrive(-speed, -speed);
        
        
    }
}

