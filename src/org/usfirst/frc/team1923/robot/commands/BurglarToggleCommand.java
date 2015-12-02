package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.org.usfirst.frc.team1923.robot.Robot;

/**
 *
 */
public class BurglarToggleCommand extends Command {

    public BurglarToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.burglarPistonSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.burglarPistonSubsystem.toggle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
