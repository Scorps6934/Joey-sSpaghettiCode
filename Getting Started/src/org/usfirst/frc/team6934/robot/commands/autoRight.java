package org.usfirst.frc.team6934.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * <h1>AutoRight</h1>
 * This class is an autonomous program that is designed for the right starting position of the field.
 * The program first gathers data from the field to know where the correct side is. If the correct
 * side is the same as the starting side then it moves to the switch and places a cube inside. If it is on
 * the opposite side, the robot simply crosses the line in order to avoid conflict.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class autoRight extends CommandGroup {

	public autoRight() {
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		//not null
		if(gameData.length() > 0) {
			
			if(gameData.charAt(0) == 'L') {

				addSequential(new forrward(0.4, 1.0), 2.25);
				addSequential(new rightTurn(), 1.6);
				addSequential(new rightTurn(), 1.6);
				
			}else if(gameData.charAt(0) == 'R'){

				addSequential(new forrward(0.4, 1.0), 2.25);
				addSequential(new buttonThingyMabobber(), 1.6);
				addSequential(new buttonThingyMabobber(), 1.6);
				//shoot cube
				addSequential(new forrward(0.4, 0.75), 0.3);
				addSequential(new shootSwitch(), 1.0);
				
			}
		}
	}
}
