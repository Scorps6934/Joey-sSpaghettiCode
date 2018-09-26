package org.usfirst.frc.team6934.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * <h1>loud</h1>
 * Makes the robot scream in pain.
 *
 * @deprecated ok so apparently it's against the rules to have your robot make sound.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class loud extends CommandBase {

	/**
	 * Default constructor.
	 */
	public loud() {
		super("loud");
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void initialize() {
	}

	/**
	 * Makes the robot scream in pain.
	 *
	 * @deprecated ok so apparently it's against the rules to have your robot make sound.
	 */
	public void execute() {
		//scram
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public boolean isFinished(){
		return true;
	}
}
