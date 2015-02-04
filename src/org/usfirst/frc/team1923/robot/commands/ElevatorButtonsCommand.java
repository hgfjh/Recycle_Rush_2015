package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team1923.robot.subsystems.DriveTrainSubsystem;

/**
 *
 */
public class ElevatorButtonsCommand extends Command {
	private int lastPressed = -1;
	private double position;
	private double timeOut;

	public ElevatorButtonsCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevatorSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		boolean button1 = Robot.oi.start.get();
		boolean button2 = Robot.oi.x.get();
		boolean button3 = Robot.oi.a.get();
		boolean button4 = Robot.oi.b.get();
		boolean button5 = Robot.oi.y.get();
		boolean button6 = Robot.oi.lB.get();
		boolean button7 = Robot.oi.rB.get();

		if(button1){
			if(lastPressed != 1){
				Robot.elevatorSubsystem.elevatorStop();
				lastPressed = 1;
			}
		} else if(button2){
			if(lastPressed != 2){
				Robot.elevatorSubsystem.elevatorStop();
				lastPressed = 2;

				this.position = RobotMap.ELEVATOR_POSITION_1;
				this.timeOut = 5.0;
				Robot.elevatorSubsystem.moveElevatorToPosition(position, timeOut);
			}
		} else if(button3){
			if(lastPressed != 3){
				Robot.elevatorSubsystem.elevatorStop();
				lastPressed = 3;

				this.position = RobotMap.ELEVATOR_POSITION_2;
				this.timeOut = 5.0;
				Robot.elevatorSubsystem.moveElevatorToPosition(position, timeOut);
				
			}
		} else if(button4){
			if(lastPressed != 4){
				Robot.elevatorSubsystem.elevatorStop();
				lastPressed = 4;
				
				this.position = RobotMap.ELEVATOR_POSITION_3;
				this.timeOut = 5.0;
				Robot.elevatorSubsystem.moveElevatorToPosition(position, timeOut);
			}
		} else if(button5){
			if(lastPressed != 5){
				Robot.elevatorSubsystem.elevatorStop();
				lastPressed = 5;				

				this.position = RobotMap.ELEVATOR_POSITION_4;
				this.timeOut = 5.0;
				Robot.elevatorSubsystem.moveElevatorToPosition(position, timeOut);
			}
		}
		
		
		if (button6){
			if (RobotMap.elevatorBottomLimitSwitch.get()) {
				Robot.elevatorSubsystem.elevatorStop();
				Robot.elevatorSubsystem.setElevatorReferance();
				lastPressed= -1;
			} else if ( RobotMap.elevatorEncoder.getDistance()<=1) {
				Robot.elevatorSubsystem.elevatorStop();
				lastPressed= -1;
				
			} else {
				Robot.elevatorSubsystem.moveElevatorDown(0.7);
			}
		} else if (button7){
				Robot.elevatorSubsystem.moveElevatorUp(0.7);
		} else if(lastPressed==1){
			if (RobotMap.elevatorBottomLimitSwitch.get()) {
				Robot.elevatorSubsystem.elevatorStop();
				Robot.elevatorSubsystem.setElevatorReferance();
				lastPressed= -1;
			} else {
				Robot.elevatorSubsystem.moveElevatorDown(0.4);
			}
		} else if(lastPressed==2 || lastPressed==3 || lastPressed==4 || lastPressed==5){
			if(Robot.elevatorSubsystem.reachedPosition()){
				Robot.elevatorSubsystem.elevatorStop();
				lastPressed= -1;
			}
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSubsystem.elevatorStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevatorSubsystem.elevatorStop();
	}
}
