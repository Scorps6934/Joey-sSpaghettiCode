/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Counter;

/**
 * Add your docs here.
 */
public class S_Lift extends Subsystem {
  DigitalInput limitswitch = new DigitalInput(RobotMap.liftLimitSwitch);
  WPI_TalonSRX motor1 = new WPI_TalonSRX(RobotMap.liftTalonPort1);
  WPI_TalonSRX motor2 = new WPI_TalonSRX(RobotMap.liftTalonPort2);
  Counter counter = new Counter(limitswitch);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void resetCounter(){
    counter.reset();
  } 

  //sees if limit switch has been hit
  public boolean isSwitchSet(){
    return counter.get() > 0;
  }
  

  public void moveMotor(double speed){
     // limit switch on always voltage aka top on limit switch
    motor1.set(speed);
    motor2.set(speed);
    
  }

  public void stopMotor() {
      motor1.set(0);
      motor2.set(0);
		}
}
