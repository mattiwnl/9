package frc.robot.commands;

import java.util.function.DoubleSupplier;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.TurretSubsystem;

public class TurretCommand extends CommandBase {

    private final TurretSubsystem m_turret;
    private final DoubleSupplier m_rotation;

    public TurretCommand(
    TurretSubsystem subsystem,
    DoubleSupplier rotation){

        m_turret = subsystem;
        m_rotation = rotation;
        addRequirements(m_turret);
    }

    @Override
    public void execute() {
        if(Robot.x >= 1 || Robot.x <= -1){
            m_turret.cTurret(ControlMode.PercentOutput, m_rotation.getAsDouble());
        }else{
            m_turret.cTurret(ControlMode.PercentOutput, 0);
        }
    }

}