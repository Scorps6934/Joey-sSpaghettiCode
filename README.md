# Joey-sSpaghettiCode
2018 FRC RobotCode - Scorps6934

Robot updated with javadoc code: [here](https://github.com/Scorps6934/Joey-sSpaghettiCode/tree/actually-fixed-for-vscode/GettingStarted/doc)

Changelog from version used during 2018 season:


Robot.java
-cleaned up dumb spacing in Robot.java that I did that I thought made it look cleaner but was really just obnoxious
-removed (most) useless and unused commented lines
-removed forward(), leftTurn(), and rightTurn() from robot.java because they're the same thing as commands that are already properly implemented
-added Java doc description for class and each method
-removed arm hold method
-removed unnecessary S_arm object
-fixed command instance names that sucked
-removed loud object

RobotMap.java
-Cleaned up dumb spacing
-Edited overly specific comments
-added javadoc explaination

Subsystems
-Renamed S_arm to S_gripper (updated uses as well)
-Renamed S_RealArm to S_arm (updated uses as well)
-cleaned up dumb spacing

Commands
-CommandBase: renamed subsystem names
-cleaned various spacing issues
-cleaned up autonomous program spacing/unused&commented commands
-changed casing on instances of subsystems in the commandBase: sgrip->sGrip, swheel -> sWheel, etc.
-added require() to command constructors that previously lacked them
-renamed arrm to toggle gripper
-renamed buttonThingyMabobber to leftTurn- shoutouts to Justin


things I still want to do:
add javadoc for the rest of subsystems and commands (forrward and on)
