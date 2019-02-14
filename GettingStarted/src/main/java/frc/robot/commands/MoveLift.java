/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.S_Lift;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class MoveLift extends CommandBase {
  private double dir;

  public MoveLift(double dir) {
    super();
    System.out.println("constructor");
    requires(slift);
    this.dir = dir;
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("initialize");
    slift.resetCounter(); // we put this early on and if
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  // EZ CLAP GG 4 STOCK CLUTCHBOX
  public void execute() {
    System.out.println("execute");
    // going up

    // logic works if limitswitch is normally open
    if (slift.isSwitchSet() && dir > 0) {
      slift.stopMotor();// Motor 0
      // OverrideGoesHere -switch (Justin Sucks)
    }
    // Going Down
    else if (slift.isSwitchSet() && dir < 0) {
      slift.moveMotor(dir);
      slift.resetCounter();
    }
    // else if(dir == 0){
    // slift.stopMotor();
    // }
    else {
      slift.moveMotor(dir);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    slift.stopMotor();
  }

}
