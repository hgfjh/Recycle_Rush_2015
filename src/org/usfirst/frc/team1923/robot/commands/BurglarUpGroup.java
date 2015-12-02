package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BurglarUpGroup extends CommandGroup {
    
    public  BurglarUpGroup() {
        addSequential(new BurglarArmCommand(1, 0.2));
        addSequential(new BurglarArmCommand(0.15));
    }
}
