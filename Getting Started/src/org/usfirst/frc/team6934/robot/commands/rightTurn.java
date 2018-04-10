package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//turn right command
public class rightTurn extends CommandBase {

	WPI_TalonSRX wLeftMotor = new WPI_TalonSRX(RobotMap.leftMotor);
	WPI_TalonSRX wRightMotor = new WPI_TalonSRX(RobotMap.rightMotor);
	
	
	public rightTurn() {
		super("rightTurn");
	}
	
	protected void initialize() {
		
	}
	
	public void execute() {
		
		wLeftMotor.set(0.25);
		wRightMotor.set(0.25);
		
		Timer.delay(1.5);
		
		//stop
		wLeftMotor.set(0);
		wRightMotor.set(0);
		Timer.delay(0.1);
		
	}
	
	public boolean isFinished(){
		return true;
	}
		
	
	
	
}
