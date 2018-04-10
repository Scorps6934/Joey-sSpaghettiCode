package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.S_wheel;

public class moveWheel extends CommandBase {

	public moveWheel() {
	}
	
	public void initialize() {
		
	}
	
	public void execute(double lJoyAxis, double rJoyAxis) {
	
		swheel.wheelMove(lJoyAxis, rJoyAxis);
		
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
