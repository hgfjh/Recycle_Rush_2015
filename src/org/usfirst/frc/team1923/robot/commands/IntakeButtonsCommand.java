 package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.org.usfirst.frc.team1923.robot.Robot;

//import org.usfirst.frc.team1923.robot.subsystems.DriveTrainSubsystem;

/**
 *
 */
public class IntakeButtonsCommand extends Command {
	private double desiredSpeed = 0;

	public IntakeButtonsCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.intakeWheelSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		int intake1 = Robot.oi.xboxController.getSharpTriggerDiff();
		boolean intakeBack = Robot.oi.back.get();
		
		if(intake1==1)
			desiredSpeed=1;
		else if (intake1==-1)
			desiredSpeed=-1;
		else if (intakeBack==true)
			desiredSpeed=0;
		
		Robot.intakeWheelSubsystem.intakeWheelsIn(desiredSpeed);		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intakeWheelSubsystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
