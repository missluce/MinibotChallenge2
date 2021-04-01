package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.Drivetrain;

public class DriveDistanceAdvance
extends CommandBase {
private final Drivetrain m_drivetrain;
private final PIDController m_leftController;
private final PIDController m_rightController;  

public DriveDistanceAdvance(Drivetrain drivetrain, double p, double i, double d, double setpoint, double tolerance) {
m_drivetrain = drivetrain;
m_leftController = new PIDController(p, i, d);
m_leftController.setSetpoint(setpoint);
m_leftController.setTolerance(tolerance);
m_rightController = new PIDController(p, i, d);
m_rightController.setSetpoint(setpoint);
m_rightController.setTolerance(tolerance);

addRequirements(drivetrain);
}

public void initialize() {
m_drivetrain.tankDrive(0, 0);
m_drivetrain.resetEncoders();
}

public void execute() {
    double leftDistance = m_drivetrain.getLeftDistanceInch();
    double rightDistance = m_drivetrain.getRightDistanceInch();

    double leftCalculation = MathUtil.clamp(m_leftController.calculate(leftDistance), -0.5, .5);
    double rightCalculation = MathUtil.clamp(m_rightController.calculate(rightDistance), -0.5, .5);

    if(leftDistance > rightDistance && leftDistance - rightDistance > .25) {
        rightCalculation += .05;
    } else if (rightDistance > leftDistance && rightDistance - leftDistance > .25) {
        leftCalculation += .05;
    }

        System.out.println("left: " + leftCalculation + "right: " + rightCalculation);
        m_drivetrain.tankDrive(leftCalculation, rightCalculation);
    }
    public void end(boolean interrupted) {
        m_drivetrain.tankDrive(0, 0);
    }

    public boolean isFinished() {
        return m_leftController.atSetpoint() && m_rightController.atSetpoint();
    }
}