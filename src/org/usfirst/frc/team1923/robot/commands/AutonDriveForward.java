package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutonDriveForward extends CommandGroup {
	
    public AutonDriveForward(){
    	this(75);
    }
    
    public AutonDriveForward(double distance) {
    	addSequential(new ElevatorSetHomeCommand());
        addSequential(new DriveDistanceCommand(distance));
    }
    

}
