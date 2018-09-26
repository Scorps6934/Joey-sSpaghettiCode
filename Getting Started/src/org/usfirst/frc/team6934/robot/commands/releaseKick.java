package org.usfirst.frc.team6934.robot.commands;

/**
 * <h1>releaseKick</h1>
 * Moves the arm in such a way that the kickstands fall and the arm moves to a resting position.
 *
 * @deprecated Innacurate due to lack of encoders.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class releaseKick extends CommandBase{

	/**
	 * Constructor that requires subsystem.
	 */
	public releaseKick() {
		requires(sArm);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public void initialize() {
	}

	/**
	 * Moves the arm so that kickstands fall.
	 *
	 * @deprecared lack of encoders make this command innacurate. It also didn't end up being super
	 * useful in practice.
	 */
	public void execute() {
		sarm.liftArm();
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public boolean isFinished() {
		return true;
	}
}
