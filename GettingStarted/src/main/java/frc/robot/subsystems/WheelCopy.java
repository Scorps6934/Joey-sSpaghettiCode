package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * <h1>S_wheel</h1> This class is a subsystem for the drive train wheels.
 * Includes objects for motor controllers that control the drive train wheels.
 * <br>
 * Sidenote: So when I was in the process of changing the robot from a basic
 * configuration to a command based configuration, I didn't have a chance to fix
 * several of the commands to use the subsystem instead of the commands. This
 * isn't a huge deal since the robotmap covers any port changes anyway. It is
 * triggering my OCD though. :)
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class WheelCopy extends Subsystem {

	//WPI_TalonSRX leftMoto = new WPI_TalonSRX(RobotMap.leftMotor);
	//WPI_TalonSRX rightMoto = new WPI_TalonSRX(RobotMap.rightMotor);

	/**
	 * Required subsystem command
	 */
		protected void initDefaultCommand() {
		}

	/**
	 * Moves the wheels according to input
	 *
	 * @param lJoyAxis input value from left joystick
	 * @param rJoyAxis input value from right joystick
	 */
		public void wheelMove(double lJoyAxis, double rJoyAxis) {
			//leftMoto.set(adjustSpeed(lJoyAxis));
			//rightMoto.set(adjustSpeed(rJoyAxis));
			
		}

	/**
	 * Stops wheels.
	 */
		public void wheelStop() {
			//leftMoto.set(0);
			//rightMoto.set(0);
			
		}

	/**
	 * A manual scaling method that attempts to round the input values in order to make the input less finicky
	 * and allow the operator to hold a steady value easily.
	 *
	 * @param input the value that is to be adjusted
	 * @return the adjusted input value
	 */
		public double adjustSpeed(double input) {
			
			if(input > 0.0) {
				
				if(input > 0.95) {
					return 0.7;
				} else if(input > 0.7) {
					return 0.5;
				}else if(input > 0.5) {
					return 0.4;
				}else if(input > 0.3) {
					return 0.3;
				}else if(input > .1) {
					return 0.2;
				}else {
					return 0.0;
				}
				
			}else if(input < 0.0){
					
				if(-input > 0.95) {
					return -0.6;
				} else if(-input > 0.7) {
					return -0.5;
				}else if(-input > 0.5) {
					return -0.4;
				}else if(-input > 0.3) {
					return -0.3;
				}else if(-input > .1) {
					return -0.2;
				}else {
					return 0.0;
				}	
					
			}else {
					return 0.0;
				}

			}

	}
