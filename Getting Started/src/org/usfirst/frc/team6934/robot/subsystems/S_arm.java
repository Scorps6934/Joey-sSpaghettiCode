package org.usfirst.frc.team6934.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6934.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

//subsystem for the gripper. Called arrm because once again we had no idea what anything was
// gonna do so we kinda just guessed. Sorry.
public class S_arm extends Subsystem {

	public static DoubleSolenoid dsol = new DoubleSolenoid(RobotMap.dsol1Module,   
															RobotMap.dsol1Forward,
															RobotMap.dsol1Reverse);   //gripper

	@Override
	public void initDefaultCommand() {
		//setDefaultCommand(new arrm());
		
	}
	
	public void open() {
		dsol.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close() {
		dsol.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stop() {
		dsol.set(DoubleSolenoid.Value.kOff);
	}
	
}
