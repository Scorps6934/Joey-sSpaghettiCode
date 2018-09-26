package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * <h1>leftTurn</h1>
 * Turns the robot 90 degrees to the left! :)
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class leftTurn extends CommandBase{

	WPI_TalonSRX wLeftMotor = new WPI_TalonSRX(RobotMap.leftMotor);
	WPI_TalonSRX wRightMotor = new WPI_TalonSRX(RobotMap.rightMotor);

	/**
	 * Default constructor.
	 */
	public buttonThingyMabobber() {
		super("leftTurn");
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void initialize() {
	}

	/**
	 * Turns the robot 90 degrees to the left.
	 */
	public void execute() {
		
		wLeftMotor.set(-0.25);
		wRightMotor.set(-0.25);
		
		Timer.delay(1.5);
		
		//stop
		wLeftMotor.set(0);
		wRightMotor.set(0);
		Timer.delay(0.1);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public boolean isFinished(){
		return true;
	}
}