package org.usfirst.frc.team6934.robot;

/**
 * <h1>RobotMap</h1>
 * The RobotMap class! This class doesn't really do anything special on it's own but is
 * vital nonetheless. This class is where each electronic component is assigned a port
 * and each input is assigned a button. This is useful because if you need to change the electronics
 * on the robot (which you will) you are able to just change it here, rather than everywhere that is used,
 * which will prevent any ports from being overlooked. Additionally, the less loose numbers you have in your code
 * the more readable and less confusing it will be. Everywhere where you would add a port, you just
 * use robotMap.yourPortHere instead. When you need to add a new port or button mapping, declare it as
 * a <strong>public static final int</strong> to ensure that the values aren't changed.
 * <br> Side note: by convention final variables are usually written in all caps but I opted to keep
 * camel casing in order to maintain readability and because every variable in this class is known to
 * be a final value anyway.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */

public class RobotMap {

	//main ports
	public static final int leftMotor = 15;
	public static final int leftVictor = 14;
	public static final int rightMotor = 0;
	public static final int rightVictor = 1;
	
	//The SPARK MOTOR channels assign to PWM Ports, not PDP Ports!
	public static final int rightArm = 0;
	public static final int rightSpinner = 3;
	
	public static final int leftArm=  1;
	public static final int leftSpinner = 2;
	
	//controllers
	public static final int logitechCont = 0; //these are swapped
	public static final int xboxCont = 1;
	
	//driving
	public static final int leftTurnButton = 5; //left bumper
	public static final int rightTurnButton = 6; //right bumper
	public static final int leftAxis = 5; //left thumbstick
	public static final int rightAxis = 1; //right thumbstick
		
	//arm
	public static final int armMoveAxis2 = 1; //left thumbs
	public static final int armMoveAxis = 5;  //right thumbstick
	public static final int gripperButton = 6;  //right bumper
	public static final int forwardSpinnersAxis = 3; //right trigger
	public static final int backSpinnersAxis = 2; //right trigger
	public static final int overrideButton = 5; //left bumper
	public static final int armHoldButton = 1; //A
	public static final int spinnerShootButton = 2; //B

	//pcm 
	public static final int dsol1Module = 6;
	public static final int dsol1Forward = 0;
	public static final int dsol1Reverse = 1;
	
	public static final int compressorModule = 6;

	//digital IO
	public static final int limSwitchPort = 0;
}
