package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//turn right command
public class forrward extends CommandBase {

	WPI_TalonSRX wLeftMotor = new WPI_TalonSRX(RobotMap.leftMotor);
	WPI_TalonSRX wRightMotor = new WPI_TalonSRX(RobotMap.rightMotor);
	
	double spd;
	double tim;
	
	public forrward(double speed, double time) {
		super("forrward");
		
		spd = speed;
		tim = time;
	}
	
	protected void initialize() {
		
	}
	
	public void execute() {
	
		
		
		wLeftMotor.set(-spd);
		wRightMotor.set(spd);
				
		Timer.delay(tim);
				
			//stop
		wLeftMotor.set(0);
		wRightMotor.set(0);
		Timer.delay(0.1);
		
	}
	
	public void execute(double speed, double time) {
		
		wLeftMotor.set(-speed);
		wRightMotor.set(speed);
				
		Timer.delay(time);
				
			//stop
		wLeftMotor.set(0);
		wRightMotor.set(0);
		Timer.delay(0.1);
		
	}
	
	public boolean isFinished(){
		return false;
	}
		
	
	
	
}
