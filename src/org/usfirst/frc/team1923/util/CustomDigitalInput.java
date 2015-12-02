package src.org.usfirst.frc.team1923.util;

import edu.wpi.first.wpilibj.DigitalInput;

public class CustomDigitalInput extends DigitalInput {

	public CustomDigitalInput(int channel) {
		super(channel);
	}

	public boolean get(){
		return !super.get();
	}
}
