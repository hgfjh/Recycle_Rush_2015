package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorBumpersCommand extends Command {

    public ElevatorBumpersCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Robot.driveTrainSubsystem.manualDrive(Robot.oi.leftStick.getY(), Robot.oi.rightStick.getY());
    	boolean rB = Robot.oi.rB.get();
    	boolean lB = !Robot.oi.lB.get();
    	
    	if (rB && !lB){
    		Robot.elevatorSubsystem.moveElevatorUp(0.2);
    	}
    	else if(!rB && lB){
    		Robot.elevatorSubsystem.moveElevatorDown(0.2);
    	}
    	else {
    		Robot.elevatorSubsystem.moveElevatorUp(0);    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorSubsystem.moveElevatorUp(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevatorSubsystem.moveElevatorUp(0);
    }
}
