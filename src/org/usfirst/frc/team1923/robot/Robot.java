package src.org.usfirst.frc.team1923.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import src.org.usfirst.frc.team1923.robot.commands.*;
import src.org.usfirst.frc.team1923.robot.subsystems.*;
import src.org.usfirst.frc.team1923.util.CustomDigitalInput;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// public static final ExampleSubsystem exampleSubsystem = new
	// ExampleSubsystem();

	public static PIDriveTrainSubsystem driveTrainSubsystem = new PIDriveTrainSubsystem();
	// public static Elevator elevator
	public static PIElevatorSubsystem elevatorSubsystem = new PIElevatorSubsystem();
	public static IntakeWheelSubsystem intakeWheelSubsystem = new IntakeWheelSubsystem();
	public static IntakePistonSubsystem intakePistonSubsystem = new IntakePistonSubsystem();
	public static LEDSubsytem ledSubsystem = new LEDSubsytem();
	public static BurglarSubsystem burglarSubsystem = new BurglarSubsystem();
	public static BurglarPistonSubsystem burglarPistonSubsystem = new BurglarPistonSubsystem();
	public static OI oi;
	public static TuskSubsystem tuskSubsystem = new TuskSubsystem();

	public CommandGroup autonomousCommand;
	public CommandGroup teleopCommand;
	public SendableChooser autoChooser;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */           
	public void robotInit() {
		// Initialize Robot
		RobotMap.init();
		oi = new OI();

		RobotMap.elevatorTopLimitSwitch = new CustomDigitalInput(9);
		RobotMap.elevatorBottomLimitSwitch = new CustomDigitalInput(8);
		// CommandBase.init();
		// instantiate the command used for the autonomous period

		SmartDashboard.putData(driveTrainSubsystem);
		SmartDashboard.putData(elevatorSubsystem);
		SmartDashboard.putData(intakeWheelSubsystem);
		SmartDashboard.putData(intakePistonSubsystem);
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Do nothing", new AutonDoNothing());
		autoChooser.addObject("CatWoman", new CatWomanAuton());
		autoChooser.addObject("Robot Set", new AutonRobotSet());
		SmartDashboard.putData("Auto Mode", autoChooser);
		addCommandsToDashboard();
		
		

		//autonomousCommand = new AutonSpin();
		teleopCommand = new TeleopCommand();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = (CommandGroup) autoChooser.getSelected();
		autonomousCommand.start();
		
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// Assign commands to buttons

		//driveTrainSubsystem.cLeft = 0;
		//driveTrainSubsystem.cRight = 0;
		intakeWheelSubsystem.cWheels = 0;

		//intakePistonSubsystem.armsOut();

		if (autonomousCommand != null)
			autonomousCommand.cancel();
		if (teleopCommand != null)
			teleopCommand.start();

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		//driveTrainSubsystem.cLeft = 0;
		//driveTrainSubsystem.cRight = 0;
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		if (teleopCommand != null)
			teleopCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void log() {
		// Log values at Dashboard
		SmartDashboard.putNumber("Left Distance",
				driveTrainSubsystem.getLeftEncoderDistance());
		SmartDashboard.putNumber("Right Distance",
				driveTrainSubsystem.getRightEncoderDistance());
		SmartDashboard.putNumber("Elevator Position",
				elevatorSubsystem.getElevatorEncoderPosition());
		SmartDashboard.putNumber("Gyro", driveTrainSubsystem.getRobotHeading());
		//SmartDashboard.putNumber("Coal Left", 
		//		driveTrainSubsystem.getCoalLeft());
		//SmartDashboard.putNumber("Coal Right",
		//		driveTrainSubsystem.getCoalRight());
		SmartDashboard.putNumber("Encoder Speed Diff", driveTrainSubsystem.getSpeedDiff());
		SmartDashboard.putBoolean("Elevator Bottom Limit Switch", RobotMap.elevatorBottomLimitSwitch.get());
		SmartDashboard.putBoolean("arms yo", intakePistonSubsystem.getArms());
		SmartDashboard.putNumber("LEFT SPEED", driveTrainSubsystem.getLeftSpeed());
		SmartDashboard.putNumber("RIGHT SPEED", driveTrainSubsystem.getRightSpeed());
	}

	public void addCommandsToDashboard() {
		// SmartDashboard.putData("Drive DRIVE_DIST_1", new
		// DriveDistanceCommand(RobotMap.DRIVE_DIST_1,5.0));
		// SmartDashboard.putData("Drive DRIVE_DIST_2", new
		// DriveDistanceCommand(RobotMap.DRIVE_DIST_2,5.0))
		SmartDashboard.putData("Set Up Home Position",
				new ElevatorSetHomeCommand());
		SmartDashboard.putData("Wheels left",
				new IntakeWheelsCommand(2, 1.0));
		SmartDashboard.putData("Wheels right",
				new IntakeWheelsCommand(3, 1.0));

		SmartDashboard.putData("Drive Distance DIST_TO_PICK_UP_TOTE",
				new DriveDistanceCommand(RobotMap.DIST_TO_PICK_UP_TOTE, 5.0));
		SmartDashboard.putData("Drive Distance DIST_TO_NEXT_TOTE",
				new DriveDistanceCommand(RobotMap.DIST_TO_NEXT_TOTE, 8.0));
		SmartDashboard.putData("Drive Distance DIST_TO_AUTON_ZONE",
				new DriveDistanceCommand(RobotMap.DIST_TO_AUTON_ZONE, 5.0));
		SmartDashboard.putData("Drive Distance -DIST_TO_PICK_UP_TOTE",
				new DriveDistanceCommand(-RobotMap.DIST_TO_PICK_UP_TOTE, 5.0));

	}

}
