package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.*;

public class fire extends SequentialCommandGroup {

    public fire() {
        addCommands(
            new ShooterCommand(RobotContainer.shootSub), 
            new WaitCommand(1), 
            new StorageCommand(RobotContainer.storageSub)
            );
    }
    
}