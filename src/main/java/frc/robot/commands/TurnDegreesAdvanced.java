package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.Drivetrain;

public class TurnDegreesAdvanced extends CommandBase{
        private final Drivetrain m_drivetrain;
        private final PIDController m_gyroController;
        private Timer m_finishedTimer;

        public TurnDegreesAdvanced(Drivetrain drivetrain, double p, double i, double d, double setpoint, double tolerance) {
            m_drivetrain = drivetrain;
            m_gyroController = new PIDController(p, i, d);
            m_gyroController.setSetpoint(setpoint);
            m_gyroController.setTolerance(tolerance);

            addRequirements(drivetrain);
        }

        public void initialize() {
            m_drivetrain.resetGyro();
            m_drivetrain.tankDrive(0, 0);
        }

        public void execute() {
            double output = MathUtil.clamp(m_gyroController.calculate(m_drivetrain.getGyroAngleZ()), -.35, .35);
            double leftOut = output;
            double rightOut = -1 * output;

            System.out.println("Left Gyro: " + leftOut + " Right Gyro: " + rightOut);
            m_drivetrain.tankDrive(leftOut, rightOut);
        }

        public void end(boolean interrupted) {
            m_drivetrain.tankDrive(0, 0);
        }

        public boolean isFinished(){
            if(m_gyroController.atSetpoint()) {
                if(m_finishedTimer == null) {
                    m_finishedTimer = new Timer();
                    m_finishedTimer.reset();
                }

                m_finishedTimer.start();

                if(m_finishedTimer.get() > .5) {
                    return true;
                }
            } else {
                if(m_finishedTimer != null) {
                    m_finishedTimer.stop();
                    m_finishedTimer = null;
                }
            }

            return false;
        }
    
}
