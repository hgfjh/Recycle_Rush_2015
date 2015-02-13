package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorSetHomeCommand extends Command {
	private boolean dontMove;
	
	public ElevatorSetHomeCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorSubsystem);
	}
	
	public ElevatorSetHomeCommand(boolean dontMove){
		this.dontMove = dontMove;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(!isFinished())
			Robot.elevatorSubsystem.moveElevatorDown(0.3);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return RobotMap.elevatorBottomLimitSwitch.get() || dontMove;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSubsystem.setElevatorReferance();
		Robot.elevatorSubsystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevatorSubsystem.stop();
	}
}
