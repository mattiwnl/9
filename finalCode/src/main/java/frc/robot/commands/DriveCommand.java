package frc.robot.commands;

import java.util.function.DoubleSupplier;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {

    private final DriveSubsystem m_drive;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;

    public DriveCommand(
    DriveSubsystem subsystem, 
    DoubleSupplier forward, 
    DoubleSupplier rotation) {

        m_drive = subsystem;
        m_forward = forward;
        m_rotation = rotation;
        addRequirements(m_drive);
    }

    @Override
    public void execute() {
        m_drive.splitArcardeDrive(ControlMode.PercentOutput, m_forward.getAsDouble(), m_rotation.getAsDouble());
    }

}