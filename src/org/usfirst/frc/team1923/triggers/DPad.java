package org.usfirst.frc.team1923.triggers;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

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
