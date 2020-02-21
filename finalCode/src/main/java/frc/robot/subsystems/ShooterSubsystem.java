package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private static final TalonFX tfxShooter = new TalonFX(Constants.Shooter);
    private static final TalonFX tfxShooter2 = new TalonFX(Constants.Shooter2);


    public ShooterSubsystem() {
        // Shooter Mode
        tfxShooter.setNeutralMode(NeutralMode.Brake);
        tfxShooter2.setNeutralMode(NeutralMode.Brake);

        tfxShooter2.setInverted(true);
    }

    public void cShoot(ControlMode mode, double pow) {
        // Shooter
        tfxShooter.set(mode, pow);
        tfxShooter2.set(mode, pow);
    }
}