package org.usfirst.frc.team6934.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


//This is a pneumatic command class. We had no idea what this was suppossed to be
//when we made it so basically all the names suck. Sorry.
public class arrm extends CommandBase{

	
	public boolean active;
	
	
	
	public arrm() {
		super("arrm");
		requires(sarm);
	}
	
	protected void initialize() {
		
		active = false;
		
	}
	
	public void execute() {
		
		
		if(!active) {
		//activate	
			active = true;
			
			sarm.open();
			
		}
		else if(active) {
		//de-activate
			active = false;
			
			sarm.close();
			
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

//JustinSucks