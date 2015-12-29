package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import src.org.usfirst.frc.team1923.robot.RobotMap;

// 3 totes auton!!!

public class AutonThreeToteNoBin extends CommandGroup {
    public  AutonThreeToteNoBin() {
    	
    	//Initialize elevator
    	addSequential(new ElevatorSetHomeCommand());
    	//Lift the first tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
    	/////////////////////We now have the first tote	
    	//Move right up to second tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE),2.2);
    	//Piston faces outwards
  //  	addSequential(new IntakePistonsCommand(false));
    	//Spins input wheels inwards
  // 	addSequential(new IntakeWheelsCommand(1));
    	//Move robot so second tote is in the robot
    	//addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
  //	addParallel(new IntakePistonsCommand(true));
    	//Drop elevator on second tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
    	//Pick up second tote
    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
/////////We now have the second tote	
    	//Move right up to third tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE), 2.2);
//    	//Add the intake wheels command here
    	//Move robot so third tote is in the robot
    	//addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE));
    	//Drop elevator on third tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
    	//Pick up third tote
    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
/////////////////////We now have the third tote	
    	//Move to face auton zone
    	addSequential(new TurnToHeadingCommand(90, 1.1, 3));
    	//Move into auton zone
    	// FOR 1923
    	//addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE + 16, 3.0));
    	// fOR 9999
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE + 5, 3.0));
    	//Turn left so when the robot backs up it stays in the auton zone
    	//addSequential(new TurnToHeadingCommand(-90, 1, 3));
    	
    	//Drop totes
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
//    	//Add the reverse intake wheels command here
    	//Back away from totes
    	addSequential(new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE - 6));    	
    }
}
