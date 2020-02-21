package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    // Drive Motors
    public static final TalonFX tfxLeftMaster = new TalonFX(Constants.DriveMasterLeft);
    public static final TalonFX tfxLeftSlave1 = new TalonFX(Constants.DriveSlaveLeft);
    public static final TalonFX tfxRightMaster = new TalonFX(Constants.DriveMasterRight);
    public static final TalonFX tfxRightSlave1 = new TalonFX(Constants.DriveSlaveRight);

    public DriveSubsystem() {
        // Follows
        tfxLeftSlave1.follow(tfxLeftMaster);
        tfxRightSlave1.follow(tfxRightMaster);

        // Invert Right
        tfxLeftMaster.setInverted(true);
        tfxLeftSlave1.setInverted(true);

        // Motor Settings
        tfxLeftMaster.setNeutralMode(NeutralMode.Coast);
        tfxRightMaster.setNeutralMode(NeutralMode.Coast);
        tfxLeftSlave1.setNeutralMode(NeutralMode.Coast);
        tfxRightSlave1.setNeutralMode(NeutralMode.Coast);
        tfxLeftMaster.configNeutralDeadband(.1, 0);
        tfxRightMaster.configNeutralDeadband(.1, 0);
    }

    public void splitArcardeDrive(ControlMode mode, double throttle, double rotation){
        tfxLeftMaster.set(mode, throttle + rotation);
        tfxRightMaster.set(mode, throttle - rotation);
    }

    
}