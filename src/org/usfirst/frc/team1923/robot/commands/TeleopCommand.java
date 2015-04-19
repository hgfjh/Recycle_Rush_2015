package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TeleopCommand extends CommandGroup {
    
    public  TeleopCommand() {
    	addParallel(new IntakeButtonsCommand());
    	//addParallel(new IntakePistonButtonsCommand());
    	addSequential(new DriveWithJoyStickCommand());
    }
}
