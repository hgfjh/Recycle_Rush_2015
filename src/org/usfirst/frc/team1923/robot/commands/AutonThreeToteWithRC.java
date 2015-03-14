package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonThreeToteWithRC extends CommandGroup {
    /*
     * elevator home
     * tusk out
     * 
     */
	
    public  AutonThreeToteWithRC() {
    	//Initialize elevator
    	addSequential(new ElevatorSetHomeCommand());
    	addSequential(new BinArmsCommand(false)); //tusk out
    	//Lift the first tote
    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	
    	addSequential(new BinArmsCommand(true)); //tusk in
    	
    	/////////////////////We now have the first tote	
    	// Take Tusk out
    	
    	
    	
    	//Move right up to second tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE),2.2);

    	addParallel(new BinArmsCommand(false));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));

    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));

    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE), 2.2);
//    	//Add the intake wheels command here
    	//Move robot so third tote is in the robot
    	//addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
    	//Drop elevator on third tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
    	//Pick up third tote
    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));

    	addSequential(new TurnToHeadingCommand(90, 1.1, 3));
    	//Move into auton zone
    	if(RobotMap.ISGALILEO)
    		addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE + 5, 3.0));
    	else
    		addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE + 16, 3.0));

    	//Turn left so when the robot backs up it stays in the auton zone
    	//addSequential(new TurnToHeadingCommand(-90, 1, 3));
    	
    	//Drop totes
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
//    	//Add the reverse intake wheels command here
    	//Back away from totes
    	addSequential(new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE - 6));    	

    	
    }
}
