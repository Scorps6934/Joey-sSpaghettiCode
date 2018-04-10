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


//subsystem for the arm. Yes it is @realArm
public class S_RealArm extends Subsystem {

	
		
		DigitalInput limSwitch = new DigitalInput(RobotMap.limSwitchPort);
		
		//Spark leftArm = new Spark(RobotMap.leftArm); 
		//Spark rightArm = new Spark(RobotMap.rightArm); 
		
		//Originally Talon xyz = new Talon
		//Changing into a spark object
		
		Spark leftArm = new Spark (RobotMap.leftArm);
		Spark rightArm = new Spark (RobotMap.rightArm);
		
		Counter count = new Counter(limSwitch);
		
		
		
		
		public boolean isSwitchSet() {
			return count.get() > 0;
			
		}

		public void initializeCounter() {
			count.reset();
		}
		
		
		public void armMove(double joyAxis) {
			
			
			leftArm.setSpeed(adjustSpeed(joyAxis));
			rightArm.setSpeed(-adjustSpeed(joyAxis));
			
			
		}
		
		public void armStop() {
			leftArm.setSpeed(0.0);
			rightArm.setSpeed(0.0);
		}
		
		public void holdArm() {
			leftArm.setSpeed(0.4);
			rightArm.setSpeed(0.4);
		}
		
		//
		public void liftArm() {
			leftArm.setSpeed(0.6);
			rightArm.setSpeed(0.6);
			
				Timer.delay(0.1);
			
			lowerArm();
		}
		
		public void raiseToSwitch() {
			leftArm.setSpeed(0.6);
			rightArm.setSpeed(0.6);
			
			Timer.delay(0.5);
			
			holdArm();
			
		}
		
		public void raiseToScale() {
			leftArm.setSpeed(0.6);
			rightArm.setSpeed(0.6);
			
			Timer.delay(1.0);
			
			holdArm();
		}
		
		public void lowerArm() {
			leftArm.setSpeed(0.075);
			rightArm.setSpeed(0.075);
			
			Timer.delay(0.75);
			
			armStop();
		}
		
		
		
		@Override
		protected void initDefaultCommand() {
		}
		
		public boolean getLimSwitch() {
			return limSwitch.get();		
		
		}
	
			
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