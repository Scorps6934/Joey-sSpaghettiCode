package org.usfirst.frc.team6934.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6934.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * <h1>S_Gripper</h1>
 * This class is a subsystem for the griper. The gripper, as I refer to it in code, is strictly the
 * short alumunium bars on the end of the arm. While moving the gripper does
 * also move the spinners, they are not affected by the gripper subsystem and thus, are not classified
 * as part of the gripper. Every action that the gripper needs to do is coded into this subsystem. Any action you
 * need to do using the arm would use this subsystem to lay out the steps for the action. The gripper subsystem
 * contains objects for the solenoid that opens/closes the gripper.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class S_gripper extends Subsystem {

	public static DoubleSolenoid dsol = new DoubleSolenoid(RobotMap.dsol1Module,   
															RobotMap.dsol1Forward,
															RobotMap.dsol1Reverse);

	/**
	 * Required subsystem command
	 */
	public void initDefaultCommand() {
	}

	/**
	 * Opens the gripper
	 */
	public void open() {
		dsol.set(DoubleSolenoid.Value.kForward);
	}

	/**
	 * Closes the gripper
	 */
	public void close() {
		dsol.set(DoubleSolenoid.Value.kReverse);
	}

	/**
	 * Unsure if this has any practical application. If I recall correctly, it mimics closing
	 * the gripper. Please refer to the FRC's solenoid documentation for more info.
	 */
	public void stop() {
		dsol.set(DoubleSolenoid.Value.kOff);
	}
	
}
