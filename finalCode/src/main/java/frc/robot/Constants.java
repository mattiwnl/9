/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants {
// Drive Constants
    // Motor IDs
    public static final int DriveMasterLeft = 1; // TalonFX
    public static final int DriveSlaveLeft = 2; // TalonFX
    public static final int DriveMasterRight = 3; // TalonFX
    public static final int DriveSlaveRight = 4; // TalonFX
// Shooter Constants
    // Motor IDs
    public static final int Shooter = 5; // TalonFX
    public static final int Shooter2 = 6; // TalonFX
// Storage Constants
    // Servo IDs
    public static final int Indexer1 = 1; // Linear Actuator
    public static final int Indexer2 = 0; // Linear Actuator
//Elevator Constants
    public static final int Elevator = 2; // VictorSPX
    // Motor IDs
    public static final int Storage = 1; // VictorSPX
// Turret Constants
    // Motor IDs
    public static final int Turret = 7; // TalonSRX
// Endgame Constants
    // Motor IDs
    public static final int Endgame = 3; // TalonSRX
// Intake Constants
    // Motor IDs
    public static final int Intake = 3; // VictorSPX
    public static final int VertIntake = 4;
    // Power
    public static final double intakePow = 0.4; // Editable - Don't go above .75
} 