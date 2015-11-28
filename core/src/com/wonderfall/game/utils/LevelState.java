package com.wonderfall.game.utils;

/**
 * This class is responsible for specific level state. For general states such
 * as inventory and scores see {@link GameState}
 */
public class LevelState {

	public static int LIVES_LEFT = 0;
	public static int SCORE = 0;
	public static float TIMER;
	// USED FOR FASTER SPAWNING VELOCITY / MORE SPAWNING RATE / HIGHER CHANCE TO
	// SPAWN BOSS
	public static float DIFFICULTY;
	public static boolean IS_PAUSED = false;
	public static boolean IS_TIME_SLOWED = false;

	public static void loadLevelState(float initialTimer)
	{
		SCORE = Constants.INITIAL_SCORE;
		DIFFICULTY = Constants.INITIAL_DIFFICULTY;
		TIMER = initialTimer;		
	}
}
