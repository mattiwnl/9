/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RobotContainer {
  	// The robot's subsystems and commands are defined here
	public final static XboxController xbox = new XboxController(0);

	public final static IntakeSubsystem	intakeSub = new IntakeSubsystem();
	public final static StorageSubsystem storageSub = new StorageSubsystem();
	public final static ShooterSubsystem shootSub = new ShooterSubsystem();

	public final static ElevatorSubsystem elevatorSub = new ElevatorSubsystem();

	public final static TurretSubsystem turretSub = new TurretSubsystem();
	public final static DriveSubsystem driveSub = new DriveSubsystem();
	
	private final static Command autoWall = new autoWall();
	private final static Command autoMiddle = new autoMiddle();
	private final static Command autoFieldCenter = new autoFieldCenter();	
  	// A chooser for autonomous commands
  	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
  	public RobotContainer() {
		// Initialize Command Buttons
		configXboxButtonBindings();

		// Initialize Drive Code
		driveSub.setDefaultCommand(
			new DriveCommand(
				driveSub, 
				() -> xbox.getY(Hand.kLeft),
				() -> xbox.getX(Hand.kRight)
			)
		);

		// Initialize Turet Code
		turretSub.setDefaultCommand(
			new TurretCommand(
				turretSub,
				() -> Robot.steeringAdjust
			)
		);
		
		m_chooser.setDefaultOption("Wall Auto", autoWall);
    		m_chooser.addOption("In front of goal Auto", autoMiddle);
		m_chooser.addOption("Field Center Auto", autoFieldCenter);
    		// Put the chooser on the dashboard
    		SmartDashboard.getTab("Autonomous").add(m_chooser);
	}
  	private void configXboxButtonBindings() {
		new JoystickButton(xbox, 5).toggleWhenPressed(new intakeAndStore()); // Left Bumper
		new JoystickButton(xbox, 6).toggleWhenPressed(new fire()); // Right Bumper

		new JoystickButton(xbox, 7).whileHeld(new ElevatorCommandUp(elevatorSub)); // Start
		new JoystickButton(xbox, 8).whileHeld(new ElevatorCommandDown(elevatorSub)); // Select
	}
	public Command getAutonomousCommand() {
    		// An ExampleCommand will run in autonomous
    		return m_chooser.getSelected();
  	}
}
