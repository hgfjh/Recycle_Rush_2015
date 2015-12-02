package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.org.usfirst.frc.team1923.robot.Robot;
import src.org.usfirst.frc.team1923.robot.RobotMap;

/**
 *
 */
public class BurglarArmCommand extends Command {

	private double speed;
	private double time;
	
    public BurglarArmCommand(double speed, double time) {
        requires(Robot.burglarSubsystem);
        this.speed = speed;
        
        if(time != -1){
        	setTimeout(time);
        }
    }
    
    public BurglarArmCommand(double speed){
    	this(speed, -1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.burglarSubsystem.set(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(time != -1){
        	return isTimedOut();
        }
        else
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
