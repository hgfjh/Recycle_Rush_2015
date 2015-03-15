package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.subsystems.BinArmSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TuskCommand extends Command {

	private boolean armsIn;

	public TuskCommand(boolean armsIn) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.binArmSubsystem);
		setTimeout(1.0);
		this.armsIn = armsIn;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (armsIn)
			Robot.binArmSubsystem.armsIn();
		else
			Robot.binArmSubsystem.armsOut();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
