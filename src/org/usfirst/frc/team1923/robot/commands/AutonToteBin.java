package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonToteBin extends CommandGroup {
    
    public  AutonToteBin() {

    	addSequential(new ElevatorSetHomeCommand());
    	addSequential(new TuskCommand(false));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	addSequential(new TurnToHeadingCommand(90,1.5,1));

    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE, 4));
    	addSequential(new TurnToHeadingCommand(-90, 1.5, 1));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
    	addSequential(new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE - 20)); 
    }
}
