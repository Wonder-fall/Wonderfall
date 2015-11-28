package com.wonderfall.game.level.entities.objects;

public class LevelObject {

	private String texture;
	private int ratio;

	public LevelObject(String texture, int ratio) {
		super();
		this.texture = texture;
		this.ratio = ratio;
	}

	public String getTexture() {
		return texture;
	}

	public int getRatio() {
		return ratio;
	}

}
