package src.org.usfirst.frc.team1923.robot.commands;
//package org.usfirst.frc.team1923.robot.commands;
//
//import org.usfirst.frc.team1923.robot.Robot;
//import org.usfirst.frc.team1923.robot.subsystems.IntakeWheelSubsystem;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class SetIntakeArmsCommand extends Command {
//	
//	private boolean state;
//
//    public SetIntakeArmsCommand(boolean state) {
//        // Use requires() here to declare subsystem dependencies
//        requires(Robot.intakeWheelSubsystem);
//        this.state = state;
//        setTimeout(1);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	//Robot.intakeWheelSubsystem.setArms(state);
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return isTimedOut();
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.intakeWheelSubsystem.stop();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	end();
//    }
//}
