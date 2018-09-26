package org.usfirst.frc.team6934.robot.commands;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * <h1>forrward</h1>
 * This class is used as a command to make the robot go forward. Useful for autonomous commands.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class forrward extends CommandBase {

	WPI_TalonSRX wLeftMotor = new WPI_TalonSRX(RobotMap.leftMotor);
	WPI_TalonSRX wRightMotor = new WPI_TalonSRX(RobotMap.rightMotor);
	
	double spd;
	double tim;

	/**
	 * Constructor that has instance variables for the inputs. Honestly, not sure when
	 * this is useful. Perhaps to track speeds over time.
	 *
	 * @param speed motor speed (-1.0 to 1.0)
	 * @param time how long the robot will move forward
	 */
	public forrward(double speed, double time) {
		super("forrward");
		
		spd = speed;
		tim = time;
	}

	/**
	 * Required due to inherted abstract methods
	 */
	protected void initialize() {
	}

	/**
	 * Execute method- moves the robot forward.
	 */
	public void execute() {
		wLeftMotor.set(-spd);
		wRightMotor.set(spd);
				
		Timer.delay(tim);
				
		//stop
		wLeftMotor.set(0);
		wRightMotor.set(0);
		Timer.delay(0.1);
	}

	/**
	 * Execute method- moves the robot forward. Takes in two parameters.
	 *
	 * @param speed motor speed (-1.0 to 1.0)
	 * @param time how long the robot will move forward
	 */
	public void execute(double speed, double time) {
		wLeftMotor.set(-speed);
		wRightMotor.set(speed);
				
		Timer.delay(time);
				
		//stop
		wLeftMotor.set(0);
		wRightMotor.set(0);
		Timer.delay(0.1);
	}

	/**
	 * Required due to inherted abstract methods
	 */
	public boolean isFinished(){
		return false;
	}
}
