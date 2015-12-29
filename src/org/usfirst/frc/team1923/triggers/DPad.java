package src.org.usfirst.frc.team1923.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import src.org.usfirst.frc.team1923.robot.Robot;

/**
 *
 */
public class DPad extends Trigger {
    
    public boolean get() {
    	//double dPadAngle = Robot.oi.xboxController.getDPad();
		//return (dPadAngle > 90 && dPadAngle < 270);
    	return false;
    }
}
