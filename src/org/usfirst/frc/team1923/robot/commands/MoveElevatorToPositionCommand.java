package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorToPositionCommand extends Command {
	private double position;
	private double timeOut;
    public MoveElevatorToPositionCommand(double position,double timeOut) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
        this.position = position;
    	this.timeOut = timeOut;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevatorSubsystem.moveElevatorToPosition(position, timeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevatorSubsystem.reachedPosition();
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
=======
import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorToPositionCommand extends Command {
	private double position, timeOut;

	/**
	 * Moves the elevator to a given position
	 * @param position the position to move the elevator to, from 1 to 4
	 * @param timeOut the manual time out in seconds, optional
	 */
	public MoveElevatorToPositionCommand(double position, double timeOut) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorSubsystem);
		requires(Robot.intakePistonSubsystem);
		this.position = position;
		this.timeOut = timeOut;
	}
	
	/**
	 * Moves the elevator to a given position
	 * @param position the position to move the elevator to, from 1 to 4
     **/
	public MoveElevatorToPositionCommand(double position) {
		this(position, 2.0);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if(position < 5)
			Robot.intakePistonSubsystem.armsOut();
		Robot.elevatorSubsystem.moveElevatorToPosition(position, timeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.elevatorSubsystem.reachedPosition();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSubsystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
>>>>>>> branch 'master' of https://github.com/Team1923/Recycle_Rush_2015.git
}
