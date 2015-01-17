package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;
/**
 *
 */
public class TurnDirection extends Command {
	
	private double degree;
	private Timer timer = new Timer();
	
    public TurnDirection(double degree) {
    	
    	this.degree = degree;
    	requires(Robot.driveTrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	Robot.driveTrainSubsystem.turnRobotHeading(degree);
    	//Robot.driveTrainSubsystem.manualDrive(-1,1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveTrainSubsystem.manualDrive(-1,1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.driveTrainSubsystem.reachedHeading();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrainSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrainSubsystem.stop();
    }
}
