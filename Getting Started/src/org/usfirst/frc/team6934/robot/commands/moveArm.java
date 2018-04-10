package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.S_RealArm;

public class moveArm extends CommandBase {

	public moveArm() {
	}
	
	public void initialize() {
		sreal.initializeCounter();
	}
	
	public void execute(double joyAxis, boolean overrideSwitch) {
		
		//if switch is set and going down set to nothing and not override
		//if switch is set and going up allow to move and reset swithc
		//else move up or down
		
		
		if(sreal.isSwitchSet() && joyAxis < 0 && !overrideSwitch) {
		sreal.armStop();
		}
		else if (sreal.isSwitchSet() && joyAxis > 0) {
		sreal.initializeCounter();
		sreal.armMove(joyAxis);
		}
		else {
		sreal.armMove(joyAxis);
		}
		
	}
	
	protected boolean isFinished() {
		return sreal.isSwitchSet();
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
		end();
	}
	
	public boolean getLimiSwitch() {
		return sreal.isSwitchSet();
	}
	
	
}
