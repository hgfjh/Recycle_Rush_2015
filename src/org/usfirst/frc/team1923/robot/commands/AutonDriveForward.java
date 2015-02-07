package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutonDriveForward extends CommandGroup {
    
    public  AutonDriveForward() {
    	addSequential(new ElevatorSetHomeCommand());
        addSequential(new DriveDistanceCommand(60));
    }
}
