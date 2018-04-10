package org.usfirst.frc.team6934.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class autoCenter extends CommandGroup {

	public autoCenter() {
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		
		
		//not null
		if(gameData.length() > 0) {
			
			if(gameData.charAt(0) == 'L') {
				
				
				//addSequential(new releaseKick(), 0.5);
				
				addSequential(new forrward(0.4, 0.75), 1.25);
				addSequential(new buttonThingyMabobber(), 1.6);
				addSequential(new buttonThingyMabobber(), 1.6);
				addSequential(new forrward(0.4, 0.5), 1.75);
				addSequential(new rightTurn(), 1.6);
				addSequential(new rightTurn(), 1.6);
				addSequential(new forrward(0.4, 0.25), 1.25);
				addSequential(new rightTurn(), 1.6);
				addSequential(new rightTurn(), 1.6);
				//shoot cube
			//	addSequential(new shootSwitch(), 1.0);
				addSequential(new forrward(0.4, 0.75), 0.3);
				addSequential(new shootSwitch(), 1.0);
				
				
			}else if (gameData.charAt(0) == 'R'){
				
				
				//addSequential(new releaseKick(), 0.5);
				
				addSequential(new forrward(0.4, 0.75), 1.25);
				addSequential(new rightTurn(), 1.6);
				addSequential(new rightTurn(), 1.6);
				addSequential(new forrward(0.4, 0.5), 1.0);
				addSequential(new buttonThingyMabobber(), 1.6);
				addSequential(new buttonThingyMabobber(), 1.6);
				addSequential(new forrward(0.4, 0.25), 1.25);
				addSequential(new buttonThingyMabobber(), 1.6);
				addSequential(new buttonThingyMabobber(), 1.6);
				//shoot cubess
			//	addSequential(new shootSwitch(),1.0);
				addSequential(new forrward(0.4, 0.75), 0.3);
				addSequential(new shootSwitch(), 1.0);
				
				//addSequential(new forrward(0.2, 0.25));
				
			}
		
	}
	
}

}