package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonSpin extends CommandGroup {
    public  AutonSpin() {

    	addSequential(new TurnToHeading(90, 5.0));
    	addSequential(new TurnToHeading(-90, 5.0));
    	// addSequential(new TurnToHeading(180, 5.0));
    	// addSequential(new TurnToHeading(-180, 5.0));
    }
}
