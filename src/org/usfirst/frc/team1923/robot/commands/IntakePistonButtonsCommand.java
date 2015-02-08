 package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team1923.robot.subsystems.DriveTrainSubsystem;

/**
 *
 */
public class IntakePistonButtonsCommand extends Command {
	private boolean lastPressed = false;

	public IntakePistonButtonsCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.intakePistonSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//double dPad = Robot.oi.xboxController.getDPad();
		boolean intakeActivate = Robot.oi.leftClick.get();//(dPad > 90 && dPad < 270);
		
		if(intakeActivate!=lastPressed){
			lastPressed=intakeActivate;
			if(lastPressed){
				Robot.intakePistonSubsystem.toggle();					
			}
		}		
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
		end();
	}
}
