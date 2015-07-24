package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakePistonsCommand extends Command {
	
	private boolean active;

	/**
	 * Actuates the intake 
	 * @param active
	 */
    public IntakePistonsCommand(boolean active) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intakePistonSubsystem);
    	this.active = active;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(active)
    		Robot.intakePistonSubsystem.armsIn();
    	else
    		Robot.intakePistonSubsystem.armsOut();
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
