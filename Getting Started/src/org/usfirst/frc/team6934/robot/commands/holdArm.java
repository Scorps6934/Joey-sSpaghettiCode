package org.usfirst.frc.team6934.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * <h1>holdArm</h1>
 * Experimental class that would attempt to hold the arm in one position.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class holdArm extends CommandBase{

	public boolean active2;

	/**
	 * Constructor that requires subsystem.
	 */
	public holdArm() {
		super("holdArm");
		requires(sArm);
	}

	/**
	 * Required due to inherted abstract methods. active2 is a toggle.
	 */
	protected void initialize() {
		active2 = false;
	}

	/**
	 * Standard execute method. Attempts to hold arm in one place.
	 *
	 * @deprecated Lack of encoders means this will only work at certain battery percentages.
	 */
	public void execute() {
		if(!active2) {				//activate
			active2 = true;
			sArm.holdArm();
		}
		else if(active2) { //de-activate
			active2 = false;
			sArm.lowerArm();
		}
		else {
		}
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