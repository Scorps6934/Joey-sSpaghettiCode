package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 

//command base; has to do with command base robot stuff. Basically when we created the robot
// project we had no idea what any of that meant so this whole build is essentially a simple
//robot with a bunch of stuff added on to make it function as a command based robot.
public class CommandBase extends Command {

	public static S_arm sarm = new S_arm();
	public static S_RealArm sreal = new S_RealArm();
	public static S_wheel swheel = new S_wheel();
	public static S_spinner Sspin = new S_spinner();
	
	public static void init() {

		
		SmartDashboard.putData("Scheduler", Scheduler.getInstance());
		
		SmartDashboard.putData("sreal",sreal);
		SmartDashboard.putBoolean("Limit Switch", sreal.getLimSwitch());
		
		
	}
	
	public CommandBase() {
		super();
	}
	
	public CommandBase(String name){
		super(name);
	}
	
	protected void initialize() {
	}

	

	protected boolean isFinished() {
	        return false;
	}

	protected void end() {
	}
	    
	protected void interrupted() {
	}

	
	
}
