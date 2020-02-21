package frc.robot.autoncommands;



import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;

public class autonMiddle extends CommandBase {
    long startTime = System.currentTimeMillis();

    public autonMiddle() {
    }
    @Override
    public void initialize() {
        Robot.tfxLeftMaster.setSelectedSensorPosition(0);
    }
    @Override
    public void execute() {
        //encoder, move forward
        int selSenPosDrive = Robot.tfxLeftMaster.getSelectedSensorPosition(0);
        int currentPosDrive = selSenPosDrive;
    while(currentPosDrive <= Robot.negLimCenter){
        if(currentPosDrive <= Robot.negLimCenter){
            Robot.tfxLeftMaster.set(ControlMode.PercentOutput, .5);
            Robot.tfxRightMaster.set(ControlMode.PercentOutput, .5);
        }
        else{
            Robot.tfxLeftMaster.set(ControlMode.PercentOutput, 0);
            Robot.tfxRightMaster.set(ControlMode.PercentOutput, 0);
        }
    }
        //"AIM AND FIRE"
    while(System.currentTimeMillis() <= startTime + 7500){
        RobotContainer.shootSub.cShoot(ControlMode.PercentOutput, -1);
        RobotContainer.storageSub.cStorage(ControlMode.PercentOutput, -.8);
        }
    }
    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
        RobotContainer.shootSub.cShoot(ControlMode.PercentOutput, 0);
        RobotContainer.storageSub.cStorage(ControlMode.PercentOutput, 0);
        Robot.tfxLeftMaster.set(ControlMode.PercentOutput, 0);
        Robot.tfxRightMaster.set(ControlMode.PercentOutput, 0);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}