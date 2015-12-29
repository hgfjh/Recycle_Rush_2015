package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.org.usfirst.frc.team1923.robot.Robot;

/**
 *
 */
public class DriveDistanceCommand extends Command {
	private double dist, timeOut;
	
	public DriveDistanceCommand(double dist, double timeOut) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrainSubsystem);
		this.dist = dist;
		this.timeOut = timeOut;
	}
	
	public DriveDistanceCommand(double dist){
		this(dist, 4.0);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrainSubsystem.driveStrightUsingEncoder(dist, timeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.driveTrainSubsystem.reachedTarget();
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
