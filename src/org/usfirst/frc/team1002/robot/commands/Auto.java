package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {

	/**
	 * Run a autonomous mode from multiple set modes.
	 *
	 * @param mode The autonomous mode to use.
	 */
	public Auto(int mode) {
		switch (mode) {
			default:
				addParallel(new Lift(-1));
				addParallel(new Fork(-1));
				addSequential(new Move(0, -0.25, 0, true), 1);
				addSequential(new Fork(1), 0.25);
				addSequential(new Lift(1), 0.5);
				addSequential(new Move(0, 0.5, 0, true), 1);
				addParallel(new Move(0, 0, 0.5), 1);
				addParallel(new Lift(-1), 0.25);
				addSequential(new Fork(-1), 0.25);
				addSequential(new Move(0, 0.25, 0), 1);
				break;
		}
	}
}
