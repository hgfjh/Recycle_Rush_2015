package src.org.usfirst.frc.team1923.robot;

public class CatWoman {
	
	private long startTime;
	
	public void autonInit(){
		this.startTime = System.currentTimeMillis();
	}
	
	public void autonPeriodic(){
		long timepassed = System.currentTimeMillis() - this.startTime;
		
		if(timepassed < 250){
			RobotMap.canGrabber1.set(1.0);
			RobotMap.canGrabber2.set(1.0);
		}
		
		if(timepassed >= 200){
			RobotMap.canGrabber1.set(0.25);
			RobotMap.canGrabber2.set(0.25);
		}
		
		if(timepassed > 180 && timepassed < 480){
			this.setLeftDrive(1);
			this.setRightDrive(-1);
		}
		
		if(timepassed > 480){
			this.setLeftDrive(0);
			this.setRightDrive(0);
		}
		
	}
	
	public void setLeftDrive(double out){
		RobotMap.frontLeftDrive.set(out);
		RobotMap.rearLeftDrive.set(out);
	}
	
	private void setRightDrive(double out){
		RobotMap.frontRightDrive.set(out);
		RobotMap.rearRightDrive.set(out);
	}
}
