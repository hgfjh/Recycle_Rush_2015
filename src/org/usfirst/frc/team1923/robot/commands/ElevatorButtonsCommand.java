package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team1923.robot.subsystems.DriveTrainSubsystem;

/**
 *
 */
public class ElevatorButtonsCommand extends Command {
	private int lastPressed = -1;
	public ElevatorButtonsCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrainSubsystem);
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

		if((lastPressed > 1 || lastPressed == -1) && button1) {
			lastPressed = 1;
		} else if((lastPressed > 2 || lastPressed == -1) && button2) {
			lastPressed = 2;

			//Robot.elevatorSubsystem.moveElevatorToPosition(position, timeOut);
		} else if((lastPressed > 3 || lastPressed == -1) && button3) {
			lastPressed = 3;
		} else if((lastPressed > 4 || lastPressed == -1) && button4) {
			lastPressed = 4;
		} else if((lastPressed > 5 || lastPressed == -1) && button5) {
			lastPressed = 5;
		}
		
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrainSubsystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
