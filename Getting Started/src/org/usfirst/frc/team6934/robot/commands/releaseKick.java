package org.usfirst.frc.team6934.robot.commands;

public class releaseKick extends CommandBase{

	public releaseKick() {
		
	}
	
	public void initialize() {
		
	}
	
	
	public void execute() {
		
		sreal.liftArm();
		
	}
	
	public boolean isFinished() {
		return true;
	}
	
}
