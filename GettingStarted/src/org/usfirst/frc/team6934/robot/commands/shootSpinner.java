package org.usfirst.frc.team6934.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * <h1>shootSpinner</h1>
 * Spins spinners at max speed to shoot cube at max speed.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class shootSpinner extends CommandBase{

	/**
	 * Constructor that requires subsystem.
	 */
	public shootSpinner() {
		super("shootSpinner");
		requires(sSpin);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void initialize() {
	}

	/**
	 * Spins spinners at max speed to shoot cube at max speed.
	 */
	public void execute() {
		sSpin.spinnerShoot();
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public boolean isFinished(){
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
	}

}