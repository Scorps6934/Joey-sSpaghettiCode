package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.S_RealArm;
import org.usfirst.frc.team6934.robot.subsystems.S_spinner;

import edu.wpi.first.wpilibj.Timer;

public class shootScale extends CommandBase {

	public shootScale() {
	}
	
	public void initialize() {
		
	}
	
	public void execute() {
		
		Sspin.spinnerOut(1.0);
		
		Timer.delay(0.5);
		
		Sspin.spinnerOut(0.0);
		sreal.lowerArm();
		
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
