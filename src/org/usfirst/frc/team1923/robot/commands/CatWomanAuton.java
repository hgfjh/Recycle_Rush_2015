package src.org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CatWomanAuton extends CommandGroup {
    
    public  CatWomanAuton() {
       addSequential(new BurglarArmCommand(1, 0.18));
       addParallel(new BurglarArmCommand(1, 0.07));
       addSequential(new DriveTimeCommand(1, 0.4));
       addSequential(new BurglarArmCommand(0.25));
    }
}
