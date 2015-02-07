package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonDriveForwardWithOneTote extends CommandGroup {
    
    public  AutonDriveForwardWithOneTote() {
        addSequential(new ElevatorSetHomeCommand());
        
    }
}
