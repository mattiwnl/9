package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StorageSubsystem extends SubsystemBase {

    private static final VictorSPX vspxStorage = new VictorSPX(Constants.Storage);

    public StorageSubsystem() {
        // Storage Mode
        vspxStorage.setNeutralMode(NeutralMode.Brake);
    }

    public void cStorage(ControlMode mode, double pow) {
        // Storage
        vspxStorage.set(mode, pow);
    }

    
}