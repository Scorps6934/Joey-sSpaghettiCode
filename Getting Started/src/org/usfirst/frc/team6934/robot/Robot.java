package org.usfirst.frc.team6934.robot;

//from the 2018 ventura regional:
// Reccomended GradleRIO (smartdashboard replacement) and Intellij IDEA (a good IDE) by EagleStrike
// ty Leo from eagle engineering (helped with auto :>)

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

/**
 * <h1>Robot</h1>
 * The robot class! This is what you compile and run to use on the roboRio.
 * The class has about 6 different methods that run at different times.
 * This class is primarily used to have the user communicate with the software and controls.
 * Please note that this robot code is currently configured to use the command-base robot system.
 * For specific information on how the code operates that isn't covered in this javadoc, please
 * refer to the FRC website.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class Robot extends IterativeRobot {
	
	//vars and objects
	Command autonomousCom;
	SendableChooser autoChooser;

	private Joystick pad = new Joystick(RobotMap.logitechCont);
	private Joystick armPad = new Joystick(RobotMap.xboxCont);

	Compressor comp = new Compressor(RobotMap.compressorModule);
	
	
	double leftSpeed;
	double rightSpeed;
	double armSpeed;
	boolean override = false;
	double backSpinSpeed;
	double forwardSpinSpeed;
	
	public leftTurn lTurn;
	public rightTurn rTurn;
	public toggleGripper tGrip;
	public moveArm mArm;
	public moveWheel mWheel;
	public spinBack mSpinb;
	public spinForward mSpinf;
	public holdArm mHold;
	public shootSpinner mShoot;
	
	//robot stuff

	/**
	 * Runs <strong>ONCE</strong> as soon as the robot is enabled, whether it be via enaabling the robot on the
	 * driver station or a tournament match starting. Used to add GUI elements to the smart dashboard
	 * and populate it with data. Also used to create instances of commands in the robot class for use.
	 * I highly reccomend trying out GradleRIO as a replacement for smartdashboard due to how finicky
	 * and unreliable the smartdashboard can be.
	 */
	public void robotInit() {
		
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("left auto", new autoLeft());
		autoChooser.addDefault("center auto", new autoCenter());
		autoChooser.addDefault("right auto", new autoRight());
		autoChooser.addDefault("safe auto",  new autoSafe());
		SmartDashboard.putData("select auto", autoChooser);
		
		autoChooser.getSelected();
		
		comp.setClosedLoopControl(true);
		
		lTurn = new leftTurn();
		rTurn = new rightTurn();
		tGrip = new toggleGripper();
		mArm = new moveArm();
		mWheel = new moveWheel();
		mSpinb = new spinBack();
		mSpinf = new spinForward();
		mHold = new holdArm();
		mShoot = new shootSpinner();
		
		SmartDashboard.putData(Scheduler.getInstance());
	}

	/**
	 * Runs <strong>ONCE</strong> as soon as the autonomous period starts/is activated via driver station.
	 * Used to gather currently selected autonomous program from smartdashboard.
	 */
	public void autonomousInit() {

	autonomousCom = (Command) autoChooser.getSelected();
	autonomousCom.start();

	}

	/**
	 * Runs peridically throughout autonomous period.
	 */
	public void autonomousPeriodic() {
		
		Scheduler.getInstance().run();

	}

	/**
	 * Runs <strong>ONCE</strong> as soon as the teleop period starts/is activated via driver station.
	 * Currently not used but present nonetheless.
	 */
	public void teleopInit() {
	}

	/**
	 * Loops throughout the teleop period. Used to draw input from drive train controller and calls movement
	 * command if non-zero value is detected in either stick. Steering is currently setup with tank controls.
	 * The drive train controller also can use a button press to turn the drive train ~90 degrees left or right.
	 * <br>Additionally, this method handles input from the arm controller. First it checks if the overide button is pressed.
	 * Next it gathers an input for the arm by splitting the arm motor value (-1.0 to 1.0) into 0.5 per analog stick.
	 * If a non-zero value is detected, the value will be sent to a command that moves the arm. If the input for the
	 * gripper is detected, the pneumatics are toggled. Next, it reads the controller for spinner input and calls the
	 * forward spinner command if a non-zero, positive value is detected or backwards spinner command if a non-zero, negative
	 * value is detected.
	 */
	public void teleopPeriodic() {
		
		// 
		// Driving
		// 
		
		//stick movement
		leftSpeed = pad.getRawAxis(RobotMap.leftAxis);
		rightSpeed = (-1) * pad.getRawAxis(RobotMap.rightAxis);
		
		if((pad.getRawAxis(RobotMap.rightAxis) != 0) 
		|| (pad.getRawAxis(RobotMap.leftAxis) != 0)) {
			mWheel.execute(leftSpeed, rightSpeed);
			Scheduler.getInstance().run();
		}
		
		//button boys
		
		//left turn
		if(pad.getRawButtonPressed(RobotMap.leftTurnButton)) {
			lTurn.execute();
			Scheduler.getInstance().run();
		}
		
		//right turn
		if(pad.getRawButtonPressed(RobotMap.rightTurnButton)) {
			rTurn.execute();
			Scheduler.getInstance().run();
		}

		//
		// Arm
		//
		
		if(armPad.getRawButton(RobotMap.overrideButton)) {
			override = true;
		}

		armSpeed = -(((0.5) * ( armPad.getRawAxis(RobotMap.armMoveAxis))) + 
					(((0.5) * armPad.getRawAxis(RobotMap.armMoveAxis2))) );
		
		if(armSpeed != 0) {
			mArm.execute(armSpeed, override);
			Scheduler.getInstance().run();
			
		}

		//pneumatic toggle
		if(armPad.getRawButtonPressed(RobotMap.gripperButton)) {
			tGrip.execute();
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
		
		if(armPad.getRawButton(RobotMap.spinnerShootButton)) {
			mShoot.execute();
			Scheduler.getInstance().run();
		}
		
	}

	/**
	 * Not gonna lie, I don't even remember when this runs because it wasn't ever useful. It's here
	 * out of pity.
	 */
	public void testPeriodic() {
	}
}