package com.wonderfall.game.level.difficulty;
/**
 * 
 * @author BarDavid
 *
 */
public class LevelDifficulty {

	private float initialSpawnRate;
	private float initialSpawnerVelocity;
	private float initialObjectsVelocity;
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

	public float getIncreaseOverTime() {
		return increaseOverTime;
	}

}
