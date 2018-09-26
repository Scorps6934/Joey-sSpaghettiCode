package org.usfirst.frc.team6934.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * <h1>AutoCenter</h1>
 * This class is an autonomous program that is designed for the center starting position of the field.
 * The program first gathers data from the field to know where the correct side is. It then moves to
 * the correct sdie and places a cube in it.
 *
 * @author Joey F. - Team 6934
 * @version 1.0
 * @since sometime in the 2018 season...
 */
public class autoCenter extends CommandGroup {

	public autoCenter() {
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		//not null
		if(gameData.length() > 0) {
			
			if(gameData.charAt(0) == 'L') {

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
				addSequential(new forrward(0.4, 0.75), 0.3);
				addSequential(new shootSwitch(), 1.0);

			}else if (gameData.charAt(0) == 'R'){

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
				addSequential(new forrward(0.4, 0.75), 0.3);
				addSequential(new shootSwitch(), 1.0);

			}
		}
	}
}