package org.usfirst.frc.team1923.util;

import org.usfirst.frc.team1923.robot.RobotMap;

/**
 * A class that contains various mathematic methods
 * @author Chris
 *
 */
public class Calculator {

	public static double ease(double current, double old, double easeIncrement) {
		if (current < old - easeIncrement) {
			current = old - easeIncrement;
		} else if (current > old + easeIncrement) {
			current = old + easeIncrement;
		} else {
			current = old;
		}
	
		return current;
	}
	
	public static double ease(double current, double old){
		return ease(current, old, RobotMap.EASE_INCREMENT);
	}
	
}
