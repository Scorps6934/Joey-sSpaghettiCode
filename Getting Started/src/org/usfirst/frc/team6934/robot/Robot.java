package org.usfirst.frc.team6934.robot;

// GradleRIO and Intellij IDEA (thats an IDE)
// ty Leo from eagle engineering

import edu.wpi.first.wpilibj.Compressor;
import java.util.function.Supplier;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

//import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team6934.robot.commands.arrm;
import org.usfirst.frc.team6934.robot.commands.autoCenter;
import org.usfirst.frc.team6934.robot.commands.autoLeft;
import org.usfirst.frc.team6934.robot.commands.autoRight;
import org.usfirst.frc.team6934.robot.commands.autoSafe;
import org.usfirst.frc.team6934.robot.commands.buttonThingyMabobber;
import org.usfirst.frc.team6934.robot.commands.holdArm;
import org.usfirst.frc.team6934.robot.commands.loud;
import org.usfirst.frc.team6934.robot.commands.moveArm;
import org.usfirst.frc.team6934.robot.commands.moveWheel;
import org.usfirst.frc.team6934.robot.commands.rightTurn;
import org.usfirst.frc.team6934.robot.commands.shootSpinner;
import org.usfirst.frc.team6934.robot.commands.spinBack;
import org.usfirst.frc.team6934.robot.commands.spinForward;
import org.usfirst.frc.team6934.robot.commands.spinBack;
import org.usfirst.frc.team6934.robot.commands.spinForward;
import edu.wpi.first.wpilibj.command.CommandGroup;


import org.usfirst.frc.team6934.robot.subsystems.S_arm;


import org.usfirst.frc.team6934.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;


public class Robot extends IterativeRobot {
	
	//vars and objects
	
	
	
	Command autonomousCom;
	SendableChooser autoChooser;
	
	
	
	private Joystick pad = new Joystick(RobotMap.logitechCont);
	private Joystick armPad = new Joystick(RobotMap.xboxCont);
	
//	WPI_TalonSRX wLeftMotor = new WPI_TalonSRX(RobotMap.leftMotor);
//	WPI_TalonSRX wRightMotor = new WPI_TalonSRX(RobotMap.rightMotor);
	

	
	Compressor comp = new Compressor(RobotMap.compressorModule);
	
	
	double leftSpeed;
	double rightSpeed;
	double armSpeed;
	boolean override = false;
	double backSpinSpeed;
	double forwardSpinSpeed;
	
	public buttonThingyMabobber button;
	public rightTurn rightButton;
	public arrm arrrm;
	public loud scram;
	public moveArm marm;
	public moveWheel meel;
	public spinBack mSpinb;
	public spinForward mSpinf;
	public holdArm mharm;
	public shootSpinner mshoot;
	
	public S_arm armSub = new S_arm();
	
	//robot stuff
	
	@Override
	public void robotInit() {
		
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("left auto", new autoLeft());
		autoChooser.addDefault("center auto", new autoCenter());
		autoChooser.addDefault("right auto", new autoRight());
		autoChooser.addDefault("safe auto",  new autoSafe());
		SmartDashboard.putData("select auto", autoChooser);
		
		autoChooser.getSelected();
		
		
		
		
		comp.setClosedLoopControl(true);
		
		button = new buttonThingyMabobber();
		rightButton = new rightTurn();
		arrrm = new arrm();
		scram = new loud();
		marm = new moveArm();
		meel = new moveWheel();
		mSpinb = new spinBack();
		mSpinf = new spinForward();
		mharm = new holdArm();
		mshoot = new shootSpinner();
		
		SmartDashboard.putData(Scheduler.getInstance());
		
		
		
		
	}


	@Override
	public void autonomousInit() {
	
		
	//Timer.delay();	
	
	autonomousCom = (Command) autoChooser.getSelected();
	autonomousCom.start();
	
	
	}

	@Override
	public void autonomousPeriodic() {
		
		Scheduler.getInstance().run();
//		autonomousCom = (CommandGroup) autoChooser.getSelected();
//		
//		autonomousCom.start();
//		
//	Timer.delay(10);
		
	}
	
	
	//forward- speed is motor speed typically -1 to 1 and time is in seconds
	public void forward(double speed, double time) {
		
		//wLeftMotor.set(speed);
		//wRightMotor.set(-speed);
		
		Timer.delay(time);
		
		//stop
		//wLeftMotor.set(0);
		//wRightMotor.set(0);
		Timer.delay(0.1);
		
	}
	
	//turns the robot left! wow!
	public void leftTurn() {

		//wLeftMotor.set(-0.25);
		//wRightMotor.set(-0.25);
		
		Timer.delay(1);
		
		//stop
		//wLeftMotor.set(0);
		//wRightMotor.set(0);
		Timer.delay(0.1);
		
	}
	
	//turns the robot right! wow!
	public void rightTurn() {
		
		//wLeftMotor.set(0.25);
		//wRightMotor.set(0.25);
		
		Timer.delay(1);
		
		//stop
		//wLeftMotor.set(0);
		//wRightMotor.set(0);
		Timer.delay(0.1);
		
	}
	

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		
		// 
		// Driving
		// 
		
		//stick movement
		leftSpeed = pad.getRawAxis(RobotMap.leftAxis);
		rightSpeed = (-1) * pad.getRawAxis(RobotMap.rightAxis);
		
		//wLeftMotor.set(leftSpeed)
		//wRightMotor.set(rightSpeed);
		
		if((pad.getRawAxis(RobotMap.rightAxis) != 0) 
		|| (pad.getRawAxis(RobotMap.leftAxis) != 0)) {
			meel.execute(leftSpeed, rightSpeed);
			Scheduler.getInstance().run();
		}
		
		//button boys
		
		//left turn
		if(pad.getRawButtonPressed(RobotMap.leftTurnButton)) {
			button.execute();
			Scheduler.getInstance().run();
		}
		
		//right turn
		if(pad.getRawButtonPressed(RobotMap.rightTurnButton)) {
			rightButton.execute();
			Scheduler.getInstance().run();
		}
		
		
		//
		// Arm
		//
		
		
		if(armPad.getRawButton(RobotMap.overrideButton)) {
			override = true;
		}
		
		
		//armSpeed = armPad.getRawAxis(RobotMap.armMoveAxis);
	
		armSpeed = -(((0.5) * ( armPad.getRawAxis(RobotMap.armMoveAxis))) + 
					(((0.5) * armPad.getRawAxis(RobotMap.armMoveAxis2))) );
		
		
		
		
		
		if(armSpeed != 0) {
			//System.out.println("total: " + armSpeed);
			//System.out.println("left: " + armPad.getRawAxis(RobotMap.armMoveAxis2));
			//System.out.println("right: " + armPad.getRawAxis(RobotMap.armMoveAxis));
			
			marm.execute(armSpeed, override);
			Scheduler.getInstance().run();
			
		}
		
		
		//pneumatic toggle
		if(armPad.getRawButtonPressed(RobotMap.gripperButton)) {
			arrrm.execute();
			Scheduler.getInstance().run();
		}
		
		
		backSpinSpeed = armPad.getRawAxis(RobotMap.backSpinnersAxis);
		forwardSpinSpeed = armPad.getRawAxis(RobotMap.forwardSpinnersAxis);
		
		//in spin
		if(armPad.getRawAxis(RobotMap.backSpinnersAxis) != 0) {
			mSpinb.execute(backSpinSpeed);
			Scheduler.getInstance().run();
		}
		else if(armPad.getRawAxis(RobotMap.forwardSpinnersAxis) != 0) {
			mSpinf.execute(forwardSpinSpeed);
			Scheduler.getInstance().run();
		}
		
		
		//arm hold
		
		if(armPad.getRawButton(RobotMap.armHoldButton)) {
			mharm.execute();
			Scheduler.getInstance().run();
		}
		
		if(armPad.getRawButton(RobotMap.spinnerShootButton)) {
			mshoot.execute();
			Scheduler.getInstance().run();
		}
		
	}


	@Override
	public void testPeriodic() {
	}
}