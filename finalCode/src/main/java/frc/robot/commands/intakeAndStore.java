package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.*;

public class intakeAndStore extends ParallelCommandGroup {

    public intakeAndStore() {
        addCommands(
            new IntakeCommand(RobotContainer.intakeSub),
            new StorageCommand(RobotContainer.storageSub)
        );
    }
}