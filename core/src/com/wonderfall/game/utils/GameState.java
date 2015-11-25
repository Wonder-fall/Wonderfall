package com.wonderfall.game.utils;

public class GameState {

	public static int LIVES_LEFT;
	public static int SCORE;
	public static float TIMER;
	// USED FOR FASTER SPAWNING VELOCITY / MORE SPAWNING RATE / HIGHER CHANCE TO
	// SPAWN BOSS
	public static float DIFFICULTY;

	public GameState(float initialTimer) {
		LIVES_LEFT = 0;
		SCORE = Constants.INITIAL_SCORE;
		DIFFICULTY = Constants.INITIAL_DIFFICULTY;
		TIMER = initialTimer;
	}
}
