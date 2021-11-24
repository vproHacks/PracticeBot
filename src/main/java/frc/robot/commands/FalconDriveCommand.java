// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class FalconDriveCommand extends CommandBase {
	private DriveSubsystem m_driveSubsystem;
    private XboxController controller;

	/**
	 * Creates a new ExampleCommand.
	 *
	 * @param subsystem The subsystem used by this command.
	 */
	public FalconDriveCommand(DriveSubsystem driveSubsystem, XboxController xbox) {
		m_driveSubsystem = driveSubsystem;
        controller = xbox;
		addRequirements(driveSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
        double leftSpeed = controller.getY(Hand.kLeft);
        double rightSpeed = controller.getY(Hand.kRight);

        double leftTrigger = controller.getTriggerAxis(Hand.kLeft);
        double rightTrigger = controller.getTriggerAxis(Hand.kRight);

        m_driveSubsystem.setFalcons(leftTrigger - rightTrigger);
        m_driveSubsystem.tankDrive(leftSpeed, rightSpeed);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
        m_driveSubsystem.stop();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
