package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.S_RealArm;
import org.usfirst.frc.team6934.robot.subsystems.S_spinner;

import edu.wpi.first.wpilibj.Timer;

/**
 * <h1>shootSwitch</h1>
 * Shoots power cube into switch.
 *
 * @deprecated Shoot macros were rarely used due to simplified auto programs.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class shootSwitch extends CommandBase {

	/**
	 * Constructor that requires subsystem.
	 */
	public shootSwitch() {
		requires(sSpin);
		requires(sArm);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public void initialize() {
	}

	/**
	 * Shoots power cube into switch.
	 *
	 * @deprecated Shoot macros were rarely used due to simplified auto programs.
	 */
	public void execute() {
		sSpin.spinnerOut(0.33);
		
		Timer.delay(0.5);
		
		sSpin.spinnerOut(0.0);
		sArm.lowerArm();
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected boolean isFinished() {
		return true;
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void end() {
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void interrupted() {
		end();
	}
}
