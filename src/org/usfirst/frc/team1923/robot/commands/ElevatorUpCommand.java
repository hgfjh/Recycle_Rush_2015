package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorUpCommand extends Command {

	private double acceleration = 0.01;
	private double velocity = 0.4;
	private double maxVelocity = 0.8;
	
    public ElevatorUpCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(velocity + acceleration < maxVelocity)
    		velocity += acceleration;
    	Robot.elevatorSubsystem.moveElevatorUp(velocity);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
