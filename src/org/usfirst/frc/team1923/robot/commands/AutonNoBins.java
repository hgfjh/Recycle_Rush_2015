package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonNoBins extends CommandGroup {
    public  AutonNoBins() {
    	
    	//Initialize elevator
    	addSequential(new ElevatorSetHomeCommand());
    	//Move elevator to above the first tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
//    	//Add the intake wheels command here
    	//Move robot so first tote is in the robot
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
    	//Drop elevator on first tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	//Pick up first tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
/////////////////////We now have the first tote	
    	//Move right up to second tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE));
//    	//Add the intake wheels command here
    	//Move robot so second tote is in the robot
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
    	//Drop elevator on second tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	//Pick up second tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
/////////////////////We now have the second tote	
    	//Move right up to third tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE));
//    	//Add the intake wheels command here
    	//Move robot so third tote is in the robot
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
    	//Drop elevator on third tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	//Pick up third tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
/////////////////////We now have the third tote	
    	//Move to face auton zone
    	addSequential(new TurnToHeading(90));
    	//Move into auton zone
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE));
    	//Turn left so when the robot backs up it stays in the auton zone
    	addSequential(new TurnToHeading(-90, 5.0));
    	
    	//Drop totes
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
//    	//Add the reverse intake wheels command here
    	//Back away from totes
    	addSequential(new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE));    	
    }
}
