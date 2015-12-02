package src.org.usfirst.frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import src.org.usfirst.frc.team1923.robot.Robot;
import src.org.usfirst.frc.team1923.robot.RobotMap;

/**
 *
 */
public class LEDSubsytem extends Subsystem {

	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public LEDSubsytem(){
		super();
		
		//detect team color and display it
		DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
		if(color == DriverStation.Alliance.Blue)
			redBlueLEDOn(true);
		else
			redBlueLEDOn(false);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	
	public void redBlueLEDOn(boolean color) {
		if(color)
			RobotMap.RedBlueLED.set(Value.kForward);
		else
			RobotMap.RedBlueLED.set(Value.kReverse);	
	}
	
	
}