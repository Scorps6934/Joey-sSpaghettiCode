package frc.robot.commands;

import frc.robot.subsystems.WheelCopy;

/**
 * <h1>moveArm</h1>
 * Moves the drive train of the robot.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class MoveWheel extends CommandBase {

	/**
	 * Constructor that requires subsystem.
	 */
	public MoveWheel() {
		requires(sWheel);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public void initialize() {
	}

	/**
	 * Moves the robot's drive train.
	 */
    public void execute(double lJoyAxis, double rJoyAxis) {
		sWheel.wheelMove(lJoyAxis, rJoyAxis);
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
