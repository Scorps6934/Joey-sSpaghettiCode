package org.usfirst.frc.team6934.robot.commands;

/**
 * <h1>spinForward</h1>
 * Spins spinners outward.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class spinForward extends CommandBase{

	/**
	 * Constructor that requires subsystem.
	 */
	public spinForward() {
		requires(sSpin);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public void initialize() {
	}

	/**
	 * Spins spinners outward.
	 */
	public void execute(double spinAxis) {
		sSpin.spinnerOut(spinAxis);
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
