package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

	private double acceleration = RobotMap.ELEVATOR_ACCELERATION;
	private double velocity = RobotMap.ELEVATOR_INITIALVELOCITY;
	private double maxVelocity = 0.8;
	
	public ElevatorSubsystem() {
		RobotMap.elevatorEncoder.reset();
		RobotMap.elevatorEncoder.setDistancePerPulse(1 / 256);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void moveElevatorUp(double speed) {
		// disablePID();
		// mode = MANUAL_MODE;
		if (velocity + acceleration < maxVelocity)
			velocity += acceleration;
		RobotMap.elevatorDrive.tankDrive(velocity, velocity);

	}

	public void moveElevatorDown(double speed) {
		// disablePID();
		// mode = MANUAL_MODE;
		if (velocity + acceleration < maxVelocity)
			velocity += acceleration;
		RobotMap.elevatorDrive.tankDrive(-velocity, -velocity);

	}
	
	public void resetVelocity(){
		this.velocity = RobotMap.ELEVATOR_INITIALVELOCITY;
	}
}
