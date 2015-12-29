package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.org.usfirst.frc.team1923.robot.Robot;

/**
 *
 */
public class TurnToHeadingCommand extends Command {
	private double angle;
	private double timeOut;
	private int totes;

	public TurnToHeadingCommand(double angle, double timeOut, int totes) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrainSubsystem);
		this.angle = angle;
		this.timeOut = timeOut;
		this.totes = totes;
	}
	
	public TurnToHeadingCommand(double angle, int totes){
		this(angle, 5.0, totes);
	}
	
	public TurnToHeadingCommand(double angle){
		this(angle, 5.0, 0);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrainSubsystem.turnRobotHeading(angle, timeOut, totes);
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
