package org.usfirst.frc.team1923.triggers;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class LeftTrigger extends Trigger {
    
    public boolean get() {
    	//return Robot.oi.xboxController.getLeftTrigger() > 0.2;
    	return false;
    	    }
}
