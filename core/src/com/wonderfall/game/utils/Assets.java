package com.wonderfall.game.utils;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Note that this class will be using TextureAtlas and TextureRegion in the
 * future. It is only temporary using Texture because it is easy. As soon as we
 * get all our true game textures, we should pack them all into TextureAtlases
 * and relate to them using TextureRegion. You should read about it
 * 
 * @author BarDavid
 *
 */
public class Assets {

	public static Skin skin;
	public static Texture player;
	public static Texture throwable1;
	public static Texture throwable2;
	public static Texture throwable3;
	public static Texture throwable4;
	public static Texture throwable_time;
	public static Texture throwable_nuke;
	public static Texture background;
	public static Texture enemy;
	public static Texture pause;
	public static Texture resume;
	public static Texture back;
	public static Texture button_unknown;

	public static Texture button_0star;
	public static Texture button_1star;
	public static Texture button_2star;
	public static Texture button_3star;

	public static BitmapFont font;

	private static Preferences gameData;

	// HERE GOES ALL ITEMS LOADED DIFFERENTLY IN EACH LEVEL
	// BECAUSE IN THE JSON YOU SHOULD SAVE STRINGS
	// IT IS A TEMP USE BECAUSE A TEXTUREATLAS ALREADY HAS STRING REFERENCES
	// BUILT IN (READ DOC I WROTE AT THE HEAD OF THIS CLASS)
	public static HashMap<String, Texture> entitiesMap = new HashMap<String, Texture>();

	public static void load() {
		// current levels,high score,items
		gameData = Gdx.app.getPreferences("wonderfall");

		skin = new Skin(Gdx.files.internal("data/uiskin.json"));

		player = new Texture(Gdx.files.internal("player/player.png"));

		throwable1 = new Texture(Gdx.files.internal("throwable/throwable1.png"));
		throwable2 = new Texture(Gdx.files.internal("throwable/throwable2.png"));
		throwable3 = new Texture(Gdx.files.internal("throwable/throwable3.png"));
		throwable4 = new Texture(Gdx.files.internal("throwable/throwable4.png"));
		throwable_time = new Texture(Gdx.files.internal("throwable/time.png"));
		throwable_time.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		throwable_nuke = new Texture(Gdx.files.internal("throwable/nuke.png"));
		entitiesMap.put("throwable1", throwable1);
		entitiesMap.put("throwable2", throwable2);
		entitiesMap.put("throwable3", throwable3);
		entitiesMap.put("throwable4", throwable4);
		entitiesMap.put("time", throwable_time);
		entitiesMap.put("nuke", throwable_nuke);

		background = new Texture(Gdx.files.internal("backgrounds/background1.png"));
		background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		enemy = new Texture(Gdx.files.internal("enemy/enemy.png"));
		pause = new Texture(Gdx.files.internal("pause.png"));
		back = new Texture(Gdx.files.internal("back.png"));
		resume = new Texture(Gdx.files.internal("play.png"));
		// buttons
		button_unknown = new Texture(Gdx.files.internal("buttons/button_unknown.png"));
		button_0star = new Texture(Gdx.files.internal("buttons/nostar.png"));
		button_1star = new Texture(Gdx.files.internal("buttons/1star.png"));
		button_2star = new Texture(Gdx.files.internal("buttons/2star.png"));
		button_3star = new Texture(Gdx.files.internal("buttons/3star.png"));

		// TODO: ARRAGE THE FONT M
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = (int) Math.ceil(20);

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/Snaps Taste.otf"));

		generator.scaleForPixelHeight((int) Math.ceil(20));
		parameter.minFilter = Texture.TextureFilter.Linear;
		parameter.magFilter = Texture.TextureFilter.Linear;
		font = generator.generateFont(parameter); // font size 12 pixels
	}

	public static void setGameData(String key, int val) {
		gameData.putInteger(key, val);
		gameData.flush();
	}

	public static int getGameData(String key) {
		return gameData.getInteger(key);
	}
}