package org.usfirst.frc.team6934.robot.subsystems;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;



//subsystem for the arm. Yes it is @realArm
public class S_spinner extends Subsystem {

	
		Spark leftSpinner = new Spark(RobotMap.leftSpinner);    // make new spinner class
		Spark rightSpinner = new Spark(RobotMap.rightSpinner);  // 
		
		
		
		public void spinnerOut(double spinAxis) {
			leftSpinner.setSpeed(-adjustSpeed(spinAxis));
			rightSpinner.setSpeed(adjustSpeed(spinAxis));
		}
		
		public void spinnerIn(double nSpinAxis) {
			leftSpinner.setSpeed(-adjustSpeed(nSpinAxis));
			rightSpinner.setSpeed(adjustSpeed(nSpinAxis));
		}
		
		public void spinnerStop() {
			leftSpinner.setSpeed(0);
			rightSpinner.setSpeed(0);	
		}
		
		public void spinnerShoot() {
			leftSpinner.setSpeed(-1.0);
			rightSpinner.setSpeed(1.0);
			
			Timer.delay(0.25);
			
			spinnerStop();
			
		}
		
		
		
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
		
		
		@Override
		protected void initDefaultCommand() {
		}
		
		
	}
