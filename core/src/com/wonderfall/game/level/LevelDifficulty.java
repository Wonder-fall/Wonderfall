package com.wonderfall.game.level;

public class LevelDifficulty {

	private float initialSpawnRate;
	private float initialSpawnerVelocity;
	private float initialObjectsVelocity;
	private int initialLives;
	private float increaseOverTime;

	public float getInitialSpawnRate() {
		return initialSpawnRate;
	}

	public float getInitialSpawnerVelocity() {
		return initialSpawnerVelocity;
	}

	public float getInitialObjectsVelocity() {
		return initialObjectsVelocity;
	}

	public int getInitialLives() {
		return initialLives;
	}

	public float getIncreaseOverTime() {
		return increaseOverTime;
	}

}
