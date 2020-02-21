package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private static final VictorSPX vspxIntake = new VictorSPX(Constants.Intake);
    private static final VictorSPX vspxVertIntake = new VictorSPX(Constants.VertIntake);
    public IntakeSubsystem() {
        // Intake Mode
        vspxIntake.setNeutralMode(NeutralMode.Brake);
    }

    public void cIntake(ControlMode mode, double pow) {
        // Intake
        vspxIntake.set(mode, pow);
    }
    public void cVertIntake(ControlMode mode, double pow) {
        // Vert Rollers
        vspxVertIntake.set(mode, pow);
    }
}