package org.usfirst.frc.team6934.robot.subsystems;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWM.PeriodMultiplier;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * <h1>S_Arm</h1>
 * This class is a subsystem for the arm. The arm, as I refer to it in code, is strictly the
 * long alumunium bars that are lifted up and down by the motors on the back. While moving the arms does
 * also move the gripper and spinners, they are not affected by the arm subsystem and thus, are not classified
 * as part of the arm. Every action that the arm needs to do is coded into this subsystem. Any action you
 * need to do using the arm would use this subsystem to lay out the steps for the action. The arm subsystem
 * contains objects for the motor controllers that move the arm, a limit switch, and a counter for the limit switch.
 * Ideally, this kind of subsytem should utilize encoders.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class S_arm extends Subsystem {

		DigitalInput limSwitch = new DigitalInput(RobotMap.limSwitchPort);
		
		Spark leftArm = new Spark (RobotMap.leftArm);
		Spark rightArm = new Spark (RobotMap.rightArm);
		
		Counter count = new Counter(limSwitch);

	/**
	 * Checks if the limit switch has been hit. A counter is used instead a boolean in case the arm moves
	 * too fast and passes over the limit switch.
	 *
	 * @return boolean value of if the limit switch has been hit
	 */
		public boolean isSwitchSet() {
			return count.get() > 0;
		}

	/**
	 * Resets the limit switch counter back to 0.
	 */
		public void initializeCounter() {
			count.reset();
		}

	/**
	 * Resets the limit switch counter back to 0.
	 *
	 * @param joyAxis input value from the arm controller
	 */
		public void armMove(double joyAxis) {
			leftArm.setSpeed(adjustSpeed(joyAxis));
			rightArm.setSpeed(-adjustSpeed(joyAxis));
		}

	/**
	 * Stops the arm motors.
	 */
		public void armStop() {
			leftArm.setSpeed(0.0);
			rightArm.setSpeed(0.0);
		}

	/**
	 * Attempts to hold the arm in place.
	 *
	 * @deprecated This was programmed when we did not have encoders. As a result, this is just an estimate of what
	 * would hold up the arm. It almost works, but it's main flaw is that the power to the motors changes with
	 * battery percentage so at full charge it might be too strong and at low charge too weak.
	 */
		public void holdArm() {
			leftArm.setSpeed(0.4);
			rightArm.setSpeed(0.4);
		}

	/**
	 * Briefly lifts the robot's arm to remove kickstands.
	 *
	 * @deprecated This was mostly a guesstimate of an action. The physical kickstands didn't cooperate super well
	 * and due to our limited autonomous program it was rarely used.
	 */
		public void liftArm() {
			leftArm.setSpeed(0.6);
			rightArm.setSpeed(0.6);
			
				Timer.delay(0.1);
			
			lowerArm();
		}

	/**
	 * Raises the arm to appropriate height to place a power cube in a switch.
	 *
	 * @deprecated Due to lack of encoders, once again this is merely an estimate. This also had no function
	 * in autonomous since the kickstands allowed the power cube to be properly placed anyway.
	 */
		public void raiseToSwitch() {
			leftArm.setSpeed(0.6);
			rightArm.setSpeed(0.6);
			
			Timer.delay(0.5);
			
			holdArm();
			
		}

	/**
	 * Raises the arm to appropriate height to shoot a power cube into the scale.
	 *
	 * @deprecated Due to lack of encoders, once again this is merely an estimate. The robot was unable to
	 * reach the scale and thus is useless.s
	 */
		public void raiseToScale() {
			leftArm.setSpeed(0.6);
			rightArm.setSpeed(0.6);
			
			Timer.delay(1.0);
			
			holdArm();
		}

	/**
	 * Gently lowers the arm to resting position.
	 *
	 * @deprecated Due to minmal autonomous program functionality, the arm never needed to lower to grab
	 * a second cube. The motor speeds were once again estimates and were not very helpful.
	 */
		public void lowerArm() {
			leftArm.setSpeed(0.075);
			rightArm.setSpeed(0.075);
			
			Timer.delay(0.75);
			
			armStop();
		}

	/**
	 * Required subsystem command
	 */
		protected void initDefaultCommand() {
		}

	/**
	 * Standard getter method.
	 *
	 * @return limitSwitch object to read further from.
	 */
		public boolean getLimSwitch() {
			return limSwitch.get();
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
					return 1.0;
				} else if(input > 0.7) {
					return 0.6;
				}else if(input > 0.49) {
					return 0.4;
				}else if(input > 0.3) {
					return 0.225;
				}else if(input > 0.1) {
					return 0.175;
				}else {
					return 0.0;
				}
				
			}else if(input < 0.0){
					
				if(-input > 0.95) {
					return -0.6;
				} else if(-input > 0.7) {
					return -0.5;
				}else if(-input > 0.475) {
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