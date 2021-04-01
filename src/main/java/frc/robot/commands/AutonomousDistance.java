// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain) {
    addCommands( 
      
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 40, .5),
    new TurnDegrees(.4, 90, drivetrain),
   // new TurnDegreesAdvanced(drivetrain, 0.088, 0, .007, 90.0, .5),    
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 15, .5),
    new TurnDegrees(.4, 90, drivetrain),
    //new TurnDegreesAdvanced(drivetrain, 0.044, 0, .007, 90.0, 0.5),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 18, .5),
    new TurnDegrees(.4, 90, drivetrain),
    //new TurnDegreesAdvanced(drivetrain, 0.044, 0, 0.007, 90.0, 0.5),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 15, .5),
    new TurnDegrees(.4, 90, drivetrain),
    //new TurnDegreesAdvanced(drivetrain, 0.044, 0, 0.007, 90, .5),
    new DriveDistanceAdvance(drivetrain, 0.3, 0, 0, 37, .5),
    new TurnDegrees(-0.4, 90, drivetrain),
    //new TurnDegreesAdvanced(drivetrain, 0.044, 0, 0.007, -90, .5),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 20, .5),
    new TurnDegrees(-0.4, 90, drivetrain),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 20, .5),
    new TurnDegrees(-.4, 90, drivetrain),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 10, .5),
    new TurnDegrees(-.4, 45, drivetrain),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 30, .5),
    new TurnDegrees(-.4, 45, drivetrain),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 18, .5),
    new TurnDegrees(-.4, 90, drivetrain),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 15, .5),
    new TurnDegrees(-.4, 80, drivetrain),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 45, .5),
    new TurnDegrees(-.4, 15, drivetrain),
    new DriveDistanceAdvance(drivetrain, .3, 0, 0, 35, .5));

  }
}
