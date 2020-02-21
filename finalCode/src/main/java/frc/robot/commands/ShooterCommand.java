package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {

    public ShooterCommand(final ShooterSubsystem shootSub) {
    }

    @Override
    public void initialize() {
        RobotContainer.shootSub.cShoot(ControlMode.PercentOutput, 1);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        RobotContainer.shootSub.cShoot(ControlMode.PercentOutput, 0);
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}