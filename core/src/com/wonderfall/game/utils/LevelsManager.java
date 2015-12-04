package com.wonderfall.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.wonderfall.game.level.Level;
import com.wonderfall.game.level.Levels;
import com.wonderfall.game.level.difficulty.LevelDifficulty;
import com.wonderfall.game.level.entities.LevelEntities;
import com.wonderfall.game.level.entities.objects.LevelBadObject;
import com.wonderfall.game.level.entities.objects.LevelGoodObject;
import com.wonderfall.game.level.entities.objects.LevelSpecialObject;
import com.wonderfall.game.level.objective.LevelObjective;

/**
 * From levels json to oop class
 * @author BarDavid
 *
 */
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

		// construct LevelSpecialObject OOP style (inheriting from LevelObject)
		json.setSerializer(LevelSpecialObject.class, new Json.Serializer<LevelSpecialObject>() {

			@SuppressWarnings("rawtypes")
			@Override
			public void write(Json json, LevelSpecialObject object, Class knownType) {
				// TODO Auto-generated method stub

			}

			@SuppressWarnings("rawtypes")
			@Override
			public LevelSpecialObject read(Json json, JsonValue jsonData, Class type) {
				return new LevelSpecialObject(jsonData.getString("texture"), jsonData.getInt("ratio"),
						jsonData.getString("action"));
			}
		});

		// construct LevelGoodObject OOP style (inheriting from LevelObject)
		json.setSerializer(LevelGoodObject.class, new Json.Serializer<LevelGoodObject>() {

			@SuppressWarnings("rawtypes")
			@Override
			public void write(Json json, LevelGoodObject object, Class knownType) {
				// TODO Auto-generated method stub

			}

			@SuppressWarnings("rawtypes")
			@Override
			public LevelGoodObject read(Json json, JsonValue jsonData, Class type) {
				return new LevelGoodObject(jsonData.getString("texture"), jsonData.getInt("ratio"),
						jsonData.getInt("score"));
			}
		});

		// construct LevelBadObject OOP style (inheriting from LevelObject)
		json.setSerializer(LevelBadObject.class, new Json.Serializer<LevelBadObject>() {

			@SuppressWarnings("rawtypes")
			@Override
			public void write(Json json, LevelBadObject object, Class knownType) {
				// TODO Auto-generated method stub

			}

			@SuppressWarnings("rawtypes")
			@Override
			public LevelBadObject read(Json json, JsonValue jsonData, Class type) {
				return new LevelBadObject(jsonData.getString("texture"), jsonData.getInt("ratio"));
			}
		});

		json.setElementType(LevelEntities.class, "specialObjects", LevelSpecialObject.class);
		json.setElementType(LevelEntities.class, "goodObjects", LevelGoodObject.class);
		json.setElementType(LevelEntities.class, "badObjects", LevelBadObject.class);

		levels = new Levels();
		levels = json.fromJson(Levels.class, levelsString);
	}

	public static void setLevel(int index) {
		if (levels != null && levels.getLevels().size() >= index)
			curLevel = levels.getLevels().get(index);
	}
	
	public static Level getLevel(int index) {
		if (levels != null && levels.getLevels().size() >= index)
			return levels.getLevels().get(index);
		return null;
	}

	public static int getLevelsAmmount() {
		return levels.getLevels().size();
	}
}
