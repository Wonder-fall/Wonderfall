package com.wonderfall.game.utils;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
	public static Texture button;
	public static Texture button_locked;
	public static Texture button_unknown;

	// HERE GOES ALL ITEMS LOADED DIFFERENTLY IN EACH LEVEL
	// BECAUSE IN THE JSON YOU SHOULD SAVE STRINGS
	// IT IS A TEMP USE BECAUSE A TEXTUREATLAS ALREADY HAS STRING REFERENCES
	// BUILT IN (READ DOC I WROTE AT THE HEAD OF THIS CLASS)
	public static HashMap<String, Texture> entitiesMap = new HashMap<String, Texture>();

	public static void load() {
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));

		player = new Texture(Gdx.files.internal("player/player.png"));

		throwable1 = new Texture(Gdx.files.internal("throwable/throwable1.png"));
		throwable2 = new Texture(Gdx.files.internal("throwable/throwable2.png"));
		throwable3 = new Texture(Gdx.files.internal("throwable/throwable3.png"));
		throwable4 = new Texture(Gdx.files.internal("throwable/throwable4.png"));
		throwable_time = new Texture(Gdx.files.internal("throwable/time.png"));
		throwable_nuke = new Texture(Gdx.files.internal("throwable/nuke.png"));
		entitiesMap.put("throwable1", throwable1);
		entitiesMap.put("throwable2", throwable2);
		entitiesMap.put("throwable3", throwable3);
		entitiesMap.put("throwable4", throwable4);
		entitiesMap.put("time", throwable_time);
		entitiesMap.put("nuke",throwable_nuke);

		background = new Texture(Gdx.files.internal("backgrounds/background1.jpg"));
		enemy = new Texture(Gdx.files.internal("enemy/enemy.png"));
		pause = new Texture(Gdx.files.internal("pause.png"));
		resume = new Texture(Gdx.files.internal("play.png"));
		button = new Texture(Gdx.files.internal("buttons/button_enabled.png"));
		button_locked = new Texture(Gdx.files.internal("buttons/button_locked.png"));
		button_unknown = new Texture(Gdx.files.internal("buttons/button_unknown.png"));
	}
}