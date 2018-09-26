package org.usfirst.frc.team6934.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * <h1>toggleGripper</h1>
 * Opens and closes the gripper. Active is a boolean for the pneumatic toggle.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class toggleGripper extends CommandBase{

	public boolean active;

	/**
	 * Constructor that requires subsystem.
	 */
	public toggleGripper() {
		super("toggleGripper");
		requires(sGrip);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void initialize() {
		active = false;
	}

	/**
	 * Opens and closes the gripper.
	 */
	public void execute() {
		
		if(!active) { //activate
			active = true;
			sGrip.open();
		}
		else if(active) { //de-activate
			active = false;
			sGrip.close();
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
//JustinSucks