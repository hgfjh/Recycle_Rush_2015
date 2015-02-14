package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeWheelsCommand extends Command {

	private int state;
	
	private double speed;
	
    public IntakeWheelsCommand(int state, double speed) {
        requires(Robot.intakeSubsystem);
        this.state = state;
        this.speed = speed;
    }
    
    public IntakeWheelsCommand(int state) {
    	this(state, 0.8);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if( state == -1) 
    		Robot.intakeSubsystem.intakeWheelsOut(speed);
    	if( state == 0)
    		this.end();
    	if( state == 1)
    		Robot.intakeSubsystem.intakeWheelsIn(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
