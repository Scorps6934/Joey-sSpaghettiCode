package org.usfirst.frc.team6934.robot.commands;

public class spinForward extends CommandBase{

	//out
	public spinForward() {
	}
	
	public void initialize() {
		
	}
	
	public void execute(double spinAxis) {
	
	Sspin.spinnerOut(spinAxis);
		
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
