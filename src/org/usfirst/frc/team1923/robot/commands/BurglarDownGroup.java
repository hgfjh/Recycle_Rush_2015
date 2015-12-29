package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BurglarDownGroup extends CommandGroup {
    
    public  BurglarDownGroup() {
        addSequential(new BurglarArmCommand(-0.25));
    }
}
