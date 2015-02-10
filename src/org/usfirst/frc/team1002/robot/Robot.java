package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auton;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

    // Joystick
    public static final Joystick stick = new Joystick(RobotMap.stick);
    public static boolean isPolar = false;

    // Secondary handlers
    public static OI oi;

    @Override
    public void robotInit() {
        oi = new OI();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        Auton.run();
    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void teleopPeriodic() {

        Scheduler.getInstance().run();

        // Switch between Cartesian and polar
        if (stick.getRawButton(11)) {
            isPolar = !isPolar;
        }

        // Drive the robot
        Drive.move(stick, isPolar);
    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}