package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {

    public IntakeCommand(final IntakeSubsystem intakeSub) {
    }
    @Override
    public void initialize() {
        RobotContainer.intakeSub.cIntake(ControlMode.PercentOutput, Constants.intakePow);
        RobotContainer.intakeSub.cVertIntake(ControlMode.PercentOutput, Constants.intakePow);
    }
    @Override
    public void execute() {
    }
    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
        RobotContainer.intakeSub.cIntake(ControlMode.PercentOutput, 0);
        RobotContainer.intakeSub.cVertIntake(ControlMode.PercentOutput, 0);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}