package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.org.usfirst.frc.team1923.robot.Robot;
import src.org.usfirst.frc.team1923.robot.RobotMap;

//import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorDownCommand extends Command {
	
	public ElevatorDownCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorSubsystem);
	}
	
	public ElevatorDownCommand(double time) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorSubsystem);
		requires(Robot.intakePistonSubsystem);
		setTimeout(time);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		if(RobotMap.elevatorEncoder.getDistance() < 15)
			Robot.intakePistonSubsystem.armsOut();
		
		if(!isFinished())
			Robot.elevatorSubsystem.moveElevatorDown(RobotMap.ELEVATOR_DOWN_SPEED);			
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return RobotMap.elevatorBottomLimitSwitch.get();

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
