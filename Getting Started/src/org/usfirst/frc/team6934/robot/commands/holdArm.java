package org.usfirst.frc.team6934.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


// assists arm height
public class holdArm extends CommandBase{

	
	public boolean active2;
	
	
	
	public holdArm() {
		super("holdArm");
		requires(sreal);
	}
	
	protected void initialize() {
		
		active2 = false;
		
	}
	
	public void execute() {
		
		
		if(!active2) {
		//activate	
			active2 = true;
			
			sreal.holdArm();
			
		}
		else if(active2) {
		//de-activate
			active2 = false;
			
			sreal.lowerArm();
			
		}
		else {
			
		}
		
		
	}
	
	public boolean isFinished(){
		return true;
	}
		
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}

}