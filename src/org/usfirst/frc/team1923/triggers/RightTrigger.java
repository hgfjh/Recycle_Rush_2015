package src.org.usfirst.frc.team1923.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import src.org.usfirst.frc.team1923.robot.Robot;

/**
 *
 */
public class RightTrigger extends Trigger {
    
    public boolean get() {
    	//return Robot.oi.xboxController.getRightTrigger() > 0.2;
    	return false;
    }
}
