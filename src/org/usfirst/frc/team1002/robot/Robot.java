package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auto;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Robot extends IterativeRobot {

    // Static Instances of subsystems
    public static final Joystick joystickMove = new Joystick(RobotMap.stick[0]);
    public static final Joystick joystickFork = new Joystick(RobotMap.stick[1]);
    public static final Drive drive = new Drive();
    public static final Forklift forklift = new Forklift();
    public static final Dashboard dash = new Dashboard();

    // Secondary handlers
    public static OI oi;
    // Camera
    public static AxisCamera camera;
    // Auto
    Command auto;

    @Override
    public void robotInit() {
        oi = new OI(joystickMove, joystickFork);
        camera = new AxisCamera("10.10.2.11");
        auto = new Auto();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().add(auto);
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        auto.cancel();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        // Drive the robot
        Drive.move(joystickMove);
    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
