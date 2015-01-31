package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonNoBins extends CommandGroup {
	
	private double testModifier = 1923.0;
	private double distanceToPickUpTote = 24.25;
	private double distanceToNextTote = 55.25 / testModifier;
	private double distanceToAutonZone = 60.0 / testModifier;
    
    public  AutonNoBins() {
    	
    	addSequential(new DriveDistanceCommand(-50, 2.0));
    	addSequential(new ResetGyroCommand());

    	addSequential(new ElevatorSetHomeCommand());
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2, 2.0));
    	//intake
    	addSequential(new DriveDistanceCommand(distanceToPickUpTote, 2.0));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1 , 2.0));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2 , 2.0));
    	//addSequential(new DriveDistanceCommand(distanceToNextTote, 2.0));
    	//intake
    	addSequential(new DriveDistanceCommand(distanceToPickUpTote, 2.0));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1 , 2.0));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2 , 2.0));
    	//addSequential(new DriveDistanceCommand(distanceToNextTote, 2.0));
    	//intake
    	addSequential(new DriveDistanceCommand(distanceToPickUpTote, 2.0));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1 , 2.0));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2 , 2.0));
    	//addSequential(new TurnToHeading(90, 2.0));
    	//addSequential(new DriveDistanceCommand(distanceToAutonZone, 2.0));
    	
    	//addSequential(new TurnToHeading(-90, 5.0));
    	
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1 , 2.0));
    	//reverse intake
    	//addSequential(new DriveDistanceCommand(-distanceToPickUpTote, 2.0));
    	addSequential(new DriveDistanceCommand(-50, 2.0));

    	
    }
}
