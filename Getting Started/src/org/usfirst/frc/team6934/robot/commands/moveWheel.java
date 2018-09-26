package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.S_wheel;

/**
 * <h1>moveArm</h1>
 * Moves the drive train of the robot.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class moveWheel extends CommandBase {

	/**
	 * Constructor that requires subsystem.
	 */
	public moveWheel() {
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
		swheel.wheelMove(lJoyAxis, rJoyAxis);
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
