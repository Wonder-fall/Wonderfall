package com.wonderfall.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.wonderfall.game.level.Level;
import com.wonderfall.game.level.LevelDifficulty;
import com.wonderfall.game.level.LevelEntities;
import com.wonderfall.game.level.LevelObjective;
import com.wonderfall.game.level.Levels;

public class LevelsManager {

	private static Levels levels;
	public static Level curLevel;

	public static void loadLevels() {
		FileHandle fileHandler = Gdx.files.internal("levels.json");
		String levelsString = fileHandler.readString();

		Json json = new Json();

		json.setElementType(Levels.class, "levels", Level.class);
		json.setElementType(Level.class, "objective", LevelObjective.class);
		json.setElementType(Level.class, "difficulty", LevelDifficulty.class);
		json.setElementType(Level.class, "entities", LevelEntities.class);

		levels = new Levels();
		levels = json.fromJson(Levels.class, levelsString);
	}

	public static void setLevel(int index) {
		if (levels != null && levels.getLevels().size() >= index)
			curLevel = levels.getLevels().get(index);
	}
	public static int getLevelsAmmount()
	{
		return levels.getLevels().size();
	}
}
