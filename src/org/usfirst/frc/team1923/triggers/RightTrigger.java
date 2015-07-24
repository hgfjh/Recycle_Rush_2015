package org.usfirst.frc.team1923.triggers;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class RightTrigger extends Trigger {
    
    public boolean get() {
    	//return Robot.oi.xboxController.getRightTrigger() > 0.2;
    	return false;
    }
}
