package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Auton3Totes2Bin extends CommandGroup {
    /*
     * elevator home
     * tusk out
     * 
     */
	
    public  Auton3Totes2Bin() {
    	//Initialize elevator
    	addSequential(new ElevatorSetHomeCommand());
    	addSequential(new TuskCommand(false)); //tusk out
    	//Lift the first tote
    	addParallel(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_1 + 2));
    	addParallel(new IntakeWheelsCommand(1));
    	
    	addSequential(new TuskCommand(true)); //tusk in
    	
    	/////////////////////We now have the first tote	
    	// Take Tusk out
    	
    	
    	
    	//Move right up to second tote
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE),2.3);
    	addSequential(new IntakePistonsCommand(true));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new IntakePistonsCommand(false));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
    	addParallel(new TuskCommand(false));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_2 + 10));
    	addSequential(new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE - 5.0), 2);
    	
    	
    	//third tote yo
    	addSequential(new IntakePistonsCommand(true)); //close piston
    	addSequential(new WaitCommand(0.5));
    	addSequential(new IntakePistonsCommand(false));
    	
    	addSequential(new TurnToHeadingCommand(90, 1.2, 3));
    	//Move into auton zone
    	addParallel(new DriveTimeCommand(1, 1.7));

    	//Turn left so when the robot backs up it stays in the auton zone
    	//addSequential(new TurnToHeadingCommand(-90, 1, 3));
    	
    	//Drop totes
    	addSequential(new MoveElevatorToPositionCommand(RobotMap.ELEVATOR_POSITION_0));
//    	//Add the reverse intake wheels command here
    	//Back away from totes
    	addSequential(new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE - 6));    	

    	
    }
}
