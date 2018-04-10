package org.usfirst.frc.team6934.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class autoSafe extends CommandGroup {

	public autoSafe() {
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		
		
		//not null
		if(gameData.length() > 0) {
			
			if(gameData.charAt(0) == 'L') {
				
				
				addSequential(new forrward(0.4, 1.0), 2.5);
				
				
			}else if(gameData.charAt(0) == 'R'){
			
				addSequential(new forrward(0.4, 1.0), 2.5);
				
			}
		
		
	}
	
	
}
}
