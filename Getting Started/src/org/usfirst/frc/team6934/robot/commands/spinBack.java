package org.usfirst.frc.team6934.robot.commands;

public class spinBack extends CommandBase{

	//in
	public spinBack() {
	}
	
	public void initialize() {
		
	}
	
	public void execute(double spinAxis) {
	
	Sspin.spinnerIn(-spinAxis);
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
		end();
	}
	
}
