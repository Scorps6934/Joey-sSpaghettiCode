package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.S_RealArm;
import org.usfirst.frc.team6934.robot.subsystems.S_spinner;

import edu.wpi.first.wpilibj.Timer;

/**
 * <h1>shootScale</h1>
 * Shoots power cube into scale.
 *
 * @deprecated The robot can't reach the scale :^)
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class shootScale extends CommandBase {

	/**
	 * Constructor that requires subsystem.
	 */
	public shootScale() {
		requires(sSpin);
		requires(sArm);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public void initialize() {
	}

	/**
	 * Shoots power cube into scale.
	 *
	 * @deprecated The robot can't reach the scale :^)
	 */
	public void execute() {
		sSpin.spinnerOut(1.0);
		
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
