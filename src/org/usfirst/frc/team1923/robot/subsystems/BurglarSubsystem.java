package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BurglarSubsystem extends Subsystem {

    public void initDefaultCommand() {

    }
    
    public void armOut(){
    	RobotMap.burglarSolenoid.set(true);
    }
    
    public void armIn(){
    	RobotMap.burglarSolenoid.set(false);
    }
    
    public void motorSpeed(double speed){
    	RobotMap.burglarTalon.set(speed);
    }
}

