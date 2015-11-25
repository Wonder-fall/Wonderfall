package com.wonderfall.game.utils;

public class GameState {

	public static int LIVES_LEFT;
	public static int SCORE;
	//USED FOR FASTER SPAWNING VELOCITY / MORE SPAWNING RATE / HIGHER CHANCE TO SPAWN BOSS
	public static float DIFFICULTY;
	
	
	public GameState(int initialLives) {
		
		LIVES_LEFT = initialLives;
		
		SCORE = Constants.INITIAL_SCORE;
		DIFFICULTY = Constants.INITIAL_DIFFICULTY;
	}
	
}
