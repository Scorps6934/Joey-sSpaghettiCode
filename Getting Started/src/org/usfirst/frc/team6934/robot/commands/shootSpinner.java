package org.usfirst.frc.team6934.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


// assists arm height
public class shootSpinner extends CommandBase{

	
	public shootSpinner() {
		super("shootSpinner");
		requires(Sspin);
	}
	
	protected void initialize() {
		
	}
	
	public void execute() {
		Sspin.spinnerShoot();		
	}
	
	public boolean isFinished(){
		return true;
	}
		
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}

}