package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutonRobotSet extends CommandGroup {
	
    public AutonRobotSet(){
    	this(-75);
    }
    
    public AutonRobotSet(double distance) {
    	addSequential(new ElevatorSetHomeCommand());
        addSequential(new DriveDistanceCommand(distance));
    }

}
