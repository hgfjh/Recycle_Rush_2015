package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.org.usfirst.frc.team1923.robot.Robot;

/**
 *
 */
public class IntakeWheelsCommand extends Command {

	private int state;
	
	private double speed;
	
    public IntakeWheelsCommand(int state, double speed) {
        requires(Robot.intakeWheelSubsystem);
        this.state = state;
        this.speed = speed;
    }
    
    public IntakeWheelsCommand(int state) {
    	this(state, 1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if( state == -1) 
    		Robot.intakeWheelSubsystem.intakeWheelsOut(speed);
    	if( state == 0)
    		this.end();
    	if( state == 1)
    		Robot.intakeWheelSubsystem.intakeWheelsIn(speed);
    	if(state == 2)
    		Robot.intakeWheelSubsystem.intakeWheelsLeft(speed);
    	if(state == 3)
    		Robot.intakeWheelSubsystem.intakeWheelsRight(speed);
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
