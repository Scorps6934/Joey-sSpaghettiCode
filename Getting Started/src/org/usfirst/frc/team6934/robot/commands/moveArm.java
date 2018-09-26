package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.S_RealArm;

/**
 * <h1>moveArm</h1>
 * Moves the robot's arm.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class moveArm extends CommandBase {

	/**
	 * Constructor that requires subsystem.
	 */
	public moveArm() {
		requires(sArm);
	}

	/**
	 * Prepares counter for limit switch.
	 */
	public void initialize() {
		sreal.initializeCounter();
	}

	/**
	 * Allows the arm to move up and down.
	 *
	 * @param joyAxis input value for arm movement
	 * @param overrideSwitch boolean value that lets the arm movement move even if limit switch has been triggered
	 */
	public void execute(double joyAxis, boolean overrideSwitch) {
		
		//if switch is set and going down set to nothing and not override
		//if switch is set and going up allow to move and reset swithc
		//else move up or down

		if(sreal.isSwitchSet() && joyAxis < 0 && !overrideSwitch) {
		sArm.armStop();
		}
		else if (sreal.isSwitchSet() && joyAxis > 0) {
		sArm.initializeCounter();
		sArm.armMove(joyAxis);
		}
		else {
		sArm.armMove(joyAxis);
		}
	}

	/**
	 * Turns the robot 90 degrees to the left.
	 */
	protected boolean isFinished() {
		return sreal.isSwitchSet();
	}

	/**
	 * Turns the robot 90 degrees to the left.
	 */
	protected void end() {
	}

	/**
	 * Turns the robot 90 degrees to the left.
	 */
	protected void interrupted() {
		end();
	}

	/**
	 * Checks if limit switch has been triggered.
	 *
	 * @return boolean value of if switch has been triggered
	 */
	public boolean getLimiSwitch() {
		return sreal.isSwitchSet();
	}

}
