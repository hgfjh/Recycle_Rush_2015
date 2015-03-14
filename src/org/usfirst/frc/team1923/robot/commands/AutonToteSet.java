package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonToteSet extends CommandGroup {
    
    public  AutonToteSet() {
    	//Move robot so first tote is in the robot
    	//addSequential(new DriveDistanceCommand(5));//RobotMap.DIST_TO_PICK_UP_TOTE + 15));
    	//Initialize elevator
    	addSequential(new ElevatorSetHomeCommand());
    	//Move elevator to above the first tote
    	//addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
//    	//Add the intake wheels command here
    	//Drop elevator on first tote
    	//addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	//Pick up first tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	addSequential(new TurnToHeadingCommand(90,1.5,1));
    	//Move into auton zone
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE, 4));
    	//Turn left so when the robot backs up it stays in the auton zone
    	addSequential(new TurnToHeadingCommand(-90, 1.5, 1));
    	//Drop totes
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
//    	//Add the reverse intake wheels command here
    	//Back away from totes
    	addSequential(new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE - 20));    	
    }
}
