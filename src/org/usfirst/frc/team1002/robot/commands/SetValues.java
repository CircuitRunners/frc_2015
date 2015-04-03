package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.subsystems.Dashboard;

import edu.wpi.first.wpilibj.command.Command;

public class SetValues extends Command {

	/**
	 * Publish booleans to dashboard.
	 * 
	 * @param booleans The booleans to place on the dashboard.
	 */
	public SetValues(boolean... booleans) {
		Dashboard.publish(booleans);
	}

	/**
	 * Publish numbers to dashboard.
	 * 
	 * @param numbers The numbers to place on the dashboard.
	 */
	public SetValues(double... numbers) {
		Dashboard.publish(numbers);
	}

	/**
	 * Publish strings to the dashboard.
	 * 
	 * @param strings The strings to place on the dashboard.
	 */
	public SetValues(String... strings) {
		Dashboard.publish(strings);
	}

	@Override
	protected void end() {
	}

	@Override
	protected void execute() {

	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
