package frc.robot.commands;

import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <h1>CommandBase</h1>
 * This class is a base for all other commands. It inherets from the command class and
 * is inhereted by every command. It contains instances of every subsystem for each command
 * to use.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class CommandBase extends Command {

	public static WheelCopy sWheel = new WheelCopy();
	public static S_Lift slift = new S_Lift();


	/**
	 * Adds info about the subsystem instances to the smartdashboard.
	 */
	public static void init() {
		SmartDashboard.putData("Scheduler", Scheduler.getInstance());
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public CommandBase() {
		super();
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public CommandBase(String name){
		super(name);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void initialize() {
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected boolean isFinished() {
	        return false;
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
