package org.usfirst.frc.team6934.robot.subsystems;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * <h1>S_spinner</h1>
 * This class is a subsystem for the spinner. The spinners, as I refer to it in code, are strictly the
 * green/blue rubber wheels on the end of the gripper. The spinners require their own actoins and thus,
 * have their own subsystem. Every action that the spinners need to do is coded into this subsystem. Any action you
 * need to do using the spinners would use this subsystem to lay out the steps for the action. The spinner subsystem
 * contains objects for the motor controllers that are mapped to the spinners.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class S_spinner extends Subsystem {

		Spark leftSpinner = new Spark(RobotMap.leftSpinner);
		Spark rightSpinner = new Spark(RobotMap.rightSpinner);

	/**
	 * Spins the spinner wheels outward (away from base the robot).
	 *
	 * @param the input value that will be used to set set the speed of the spinners
	 */
		public void spinnerOut(double spinAxis) {
			leftSpinner.setSpeed(-adjustSpeed(spinAxis));
			rightSpinner.setSpeed(adjustSpeed(spinAxis));
		}

	/**
	 * Spins the spinner wheels inward (towards from base the robot).
	 *
	 * @param the input value that will be used to set set the speed of the spinners
	 */
		public void spinnerIn(double nSpinAxis) {
			leftSpinner.setSpeed(-adjustSpeed(nSpinAxis));
			rightSpinner.setSpeed(adjustSpeed(nSpinAxis));
		}

	/**
	 * Stops the spinners.
	 */
		public void spinnerStop() {
			leftSpinner.setSpeed(0);
			rightSpinner.setSpeed(0);	
		}

	/**
	 * Macro to shoot a power cube outwards at max speed.
	 */
		public void spinnerShoot() {
			leftSpinner.setSpeed(-1.0);
			rightSpinner.setSpeed(1.0);
			
			Timer.delay(0.25);
			
			spinnerStop();
			
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
					return 0.8;
				} else if(input > 0.7) {
					return 0.65;
				}else if(input > 0.5) {
					return 0.5;
				}else if(input > 0.3) {
					return 0.35;
				}else if(input > .1) {
					return 0.2;
				}else {
					return 0.0;
				}
				
			}else if(input < 0.0){
					
				if(-input > 0.95) {
					return -0.8;
				} else if(-input > 0.7) {
					return -0.65;
				}else if(-input > 0.5) {
					return -0.5;
				}else if(-input > 0.3) {
					return -0.35;
				}else if(-input > .1) {
					return -0.2;
				}else {
					return 0.0;
				}	
					
			}else {
					return 0.0;
				}
				
				
			}


	/**
	 * Required subsystem command
	 */
		protected void initDefaultCommand() {
		}

	}
