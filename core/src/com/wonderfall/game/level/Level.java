package com.wonderfall.game.level;

import java.util.ArrayList;

import com.wonderfall.game.level.difficulty.LevelDifficulty;
import com.wonderfall.game.level.entities.LevelEntities;
import com.wonderfall.game.level.objective.LevelObjective;

public class Level {

	private String name;
	private LevelObjective objective;
	private LevelDifficulty difficulty;
	private ArrayList<String> dependencies;
	private LevelEntities entities;

	public String getName() {
		return name;
	}

	public LevelObjective getObjective() {
		return objective;
	}

	public LevelDifficulty getDifficulty() {
		return difficulty;
	}

	public ArrayList<String> getDependencies() {
		return dependencies;
	}

	public LevelEntities getEntities() {
		return entities;
	}

}
