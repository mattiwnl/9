/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
// import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
//Global Variables
    // Initiate Robot Container
    private RobotContainer m_robotContainer;
    
    //NavX Angle Device
    // public static AHRS ahrs;

    // Limelight Network Table Global Variables
    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;
    public static double x;
    public static double y;
    public static double area;

    // Turret Values and Constants
    public static final TalonFX turretMotor = new TalonFX(Constants.Turret);
    public static double steeringAdjust = 0.0;
    private final double Kp = -.04;
    private final double min_command = .005;
    
    //Encoder Details
    int selSenPosInit = turretMotor.getSelectedSensorPosition(0);
    int currentPosInit = selSenPosInit;
    final double posLimTurret = 0 + (6144);
    final double negLimTurret = 0 - (6144);

    public final static double negLimCenter = 0 - (54087.2611); //actual value is 54787, took off 700 for overshot
  
    // Sensors
    public final DigitalInput breakBeam = new DigitalInput(0);

    @Override
    public void robotInit() {
        // Instantiate our RobotContainer. This will perform all our button bindings.
        m_robotContainer = new RobotContainer();

        // Initiate the limelight network table
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");

    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();

        // Limelight Data w/ sSmartDashboard
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);

        SmartDashboard.putNumber("Limelight X", x);
        SmartDashboard.putNumber("Limelight Y", y);
        SmartDashboard.putNumber("Limelight Area", area);

        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); // LED On
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); // Vision Processing

        // Turret Adjustment
        final double headingError = -Robot.x;
        System.out.println(headingError);
        if (Robot.x > 1 && currentPosDrive <= posLimTurret){
             steeringAdjust = KpheadingError - min_command;
        }else if(Robot.x < 1 && currentPosDrive >= negLimTurret){
             steeringAdjust = KpheadingError + min_command;
        }else{
            steeringAdjust = 0;
        }
    }
    

    @Override
    public void autonomousInit() {
        
    }

    @Override
    public void autonomousPeriodic() {
    }
    
    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {

    }
}
