package src.org.usfirst.frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import src.org.usfirst.frc.team1923.robot.RobotMap;

/**
 *
 */
public class BurglarPistonSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	private boolean state = false;

	public void out() {
		RobotMap.burglarIn.set(false);
		RobotMap.burglarOut.set(true);
	}

	public void in() {
		RobotMap.burglarIn.set(true);
		RobotMap.burglarOut.set(false);
	}

	public void toggle() {
		if (state) {
			out();
			state = false;
		} else {
			in();
			state = true;

		}
	}
}
