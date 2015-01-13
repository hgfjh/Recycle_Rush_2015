package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autonRoutine1 extends CommandGroup {
    
    public  autonRoutine1() {
    	addSequential(new WaitHalfSecond()); // Replace with Grab Tote
    	addSequential(new WaitHalfSecond()); // Replace with Elevate Tote
    	addSequential(new TurnLeft90());
    	addSequential(new ArcRight180());
    	addSequential(new TurnLeft90());
    	addSequential(new MoveForwardOneSecond()); //Replace with Put Tote on Other Tote

    	addSequential(new WaitHalfSecond()); // Replace with Grab Tote
    	addSequential(new WaitHalfSecond()); // Replace with Elevate Tote
    	addSequential(new TurnLeft90());
    	addSequential(new ArcRight180());
    	addSequential(new TurnLeft90());
    	addSequential(new MoveForwardOneSecond()); //Replace with Put Tote on Other Tote

    	addSequential(new WaitHalfSecond()); // Replace with Grab Tote
    	addSequential(new TurnRight90());
    	addSequential(new MoveForwardTwoSecond());
    }
}
