package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutonCanBurglar extends CommandGroup {
    
    public  AutonCanBurglar() {
    	addSequential(new BurglarArmCommand("out"));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new BurglarCimCommand(1.0, 1.0));
    }
}
