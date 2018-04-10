package org.usfirst.frc.team6934.robot;


public class RobotMap {

	//main ports
	public static final int leftMotor = 15;
	public static final int leftVictor = 14;
	public static final int rightMotor = 0;
	public static final int rightVictor = 1;
	
	//The SPARK MOTOR channels assign to PWM Ports, not PDP Ports!
	
	public static final int rightArm = 0;
	public static final int rightSpinner = 3;
	
	//Im going to change the values from LA10 LS11 to LA2 and LS3
	
	public static final int leftArm=  1;
	public static final int leftSpinner = 2;
	
	
	
	//controllers
	public static final int logitechCont = 0; //these are swapped
	public static final int xboxCont = 1;
	
		//xbox - driving
		public static final int leftTurnButton = 5; //left bumper
		public static final int rightTurnButton = 6; //right bumper
		public static final int leftAxis = 5; //left thumbstick
		public static final int rightAxis = 1; //right thumbstick
		
		
		//logitech - arm
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
	
	
	//
	
}
