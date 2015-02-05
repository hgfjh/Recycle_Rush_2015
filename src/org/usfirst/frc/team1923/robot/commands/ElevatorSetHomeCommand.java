package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorSetHomeCommand extends Command {

	public ElevatorSetHomeCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
			Robot.elevatorSubsystem.moveElevatorDown(0.4);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return RobotMap.elevatorBottomLimitSwitch.get();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSubsystem.moveElevatorDown(0.0);
		Robot.elevatorSubsystem.setElevatorReferance();
		Robot.elevatorSubsystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevatorSubsystem.moveElevatorDown(0.0);
		Robot.elevatorSubsystem.stop();
	}
}
