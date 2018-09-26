package org.usfirst.frc.team6934.robot.commands;

/**
 * <h1>spinBack</h1>
 * Spins spinners inward.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class spinBack extends CommandBase{

	/**
	 * Constructor that requires subsystem.
	 */
	public spinBack() {
		requires(sSpin);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public void initialize() {
	}

	/**
	 * Spins spinners inward.
	 */
	public void execute(double spinAxis) {
		sSpin.spinnerIn(-spinAxis);
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
