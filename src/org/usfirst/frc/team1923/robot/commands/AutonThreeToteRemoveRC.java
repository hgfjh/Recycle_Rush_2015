package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import src.org.usfirst.frc.team1923.robot.RobotMap;

/**
 *
 */
public class AutonThreeToteRemoveRC extends CommandGroup {
    
    public  AutonThreeToteRemoveRC() {
    	//Initialize elevator
    	addSequential(new ElevatorSetHomeCommand());
    	//Lift the first tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_RC));
    	
    	addSequential(new IntakePistonsCommand(true));
    	addParallel(new IntakeWheelsCommand(2));
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE* 0.66),1.1);
    	addSequential(new IntakePistonsCommand(false));
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE * 0.34),1.1);
    	
    	addSequential(new IntakePistonsCommand(true));
    	//addSequential(new IntakeWheelsCommand(1));
    	addSequential(new IntakePistonsCommand(false));
    	
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
    	//Pick up second tote
    	
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_RC));
    	
    	addSequential(new IntakePistonsCommand(true));
    	addSequential(new IntakeWheelsCommand(2));
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE * 0.66),1.1);
    	addSequential(new IntakePistonsCommand(false));
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE *0.34),1.1);
    	
    	addSequential(new IntakePistonsCommand(true));
    	//addSequential(new IntakeWheelsCommand(1));
    	addSequential(new IntakePistonsCommand(false));
    	

/////////We now have the second tote	
    	//Move right up to third tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE), 2.2);
    	
    	
    	
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
    	//Pick up third tote
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1));
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
