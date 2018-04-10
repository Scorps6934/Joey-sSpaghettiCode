package org.usfirst.frc.team6934.robot.subsystems;

import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;



//subsystem for the arm. Yes it is @realArm
public class S_wheel extends Subsystem {

		//life S_RealArm and moveArm
	
	
		WPI_TalonSRX leftMoto = new WPI_TalonSRX(RobotMap.leftMotor);
		WPI_TalonSRX rightMoto = new WPI_TalonSRX(RobotMap.rightMotor);
		WPI_VictorSPX leftVicto = new WPI_VictorSPX(RobotMap.leftVictor);
		WPI_VictorSPX rightVicto = new WPI_VictorSPX(RobotMap.rightVictor);
		
		
		
		@Override
		protected void initDefaultCommand() {
		}
		
		
		public void wheelMove(double lJoyAxis, double rJoyAxis) {
			//left
			leftMoto.set(adjustSpeed(lJoyAxis));
			leftVicto.set(adjustSpeed(lJoyAxis));
			
			//right
			rightMoto.set(adjustSpeed(rJoyAxis));
			rightVicto.set(adjustSpeed(rJoyAxis));
			
		}
		
		public void wheelStop() {
			leftMoto.set(0);
			leftVicto.set(0);
			
			rightMoto.set(0);
			rightVicto.set(0);
		}
		
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
