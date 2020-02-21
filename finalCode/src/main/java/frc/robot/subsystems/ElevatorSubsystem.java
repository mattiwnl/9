package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

    private static final VictorSPX vspxElevator = new VictorSPX(Constants.Elevator);

    public ElevatorSubsystem() {
        // Intake Mode
        vspxElevator.setNeutralMode(NeutralMode.Brake);
    }

    public void cElevator(ControlMode mode, double pow) {
        // Intake
        vspxElevator.set(mode, pow);
    }

    
}