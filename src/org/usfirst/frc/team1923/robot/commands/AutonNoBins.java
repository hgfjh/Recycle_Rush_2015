package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

// 3 totes auton!!!

public class AutonNoBins extends CommandGroup {
    public  AutonNoBins() {
    	
    	//Initialize elevator
    	addSequential(new ElevatorSetHomeCommand());
    	//Lift the first tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
    	/////////////////////We now have the first tote	
    	//Move right up to second tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE));
    	//Piston faces outwards
  //  	addSequential(new IntakePistonsCommand(false));
    	//Spins input wheels inwards
  // 	addSequential(new IntakeWheelsCommand(1));
    	//Move robot so second tote is in the robot
    	//addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
  //	addParallel(new IntakePistonsCommand(true));
    	//Drop elevator on second tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	//Pick up second tote
    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
/////////We now have the second tote	
    	//Move right up to third tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE));
//    	//Add the intake wheels command here
    	//Move robot so third tote is in the robot
    	//addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
    	//Drop elevator on third tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	//Pick up third tote
    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2));
/////////////////////We now have the third tote	
    	//Move to face auton zone
    	addSequential(new TurnToHeadingCommand(90,1.25, 3));
    	//Move into auton zone
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE));
    	//Turn left so when the robot backs up it stays in the auton zone
    	addSequential(new TurnToHeadingCommand(-90, 0.75, 3));
    	
    	//Drop totes
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
//    	//Add the reverse intake wheels command here
    	//Back away from totes
    	addSequential(new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE - 20));    	
    }
}
