package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {

    private static final TalonSRX tsrxTurret = new TalonSRX(Constants.Turret);

    public TurretSubsystem() {
        // Intake Mode
        tsrxTurret.setNeutralMode(NeutralMode.Brake);
    }

    public void cTurret(ControlMode mode, double pow) {
        // Intake
        tsrxTurret.set(mode, pow);
    }
}