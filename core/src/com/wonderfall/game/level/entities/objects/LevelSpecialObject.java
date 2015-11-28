package com.wonderfall.game.level.entities.objects;

public class LevelSpecialObject extends LevelObject {

	private String action;

	public LevelSpecialObject(String texture, int ratio, String action) {
		super(texture, ratio);
		this.action = action;
	}

	public String getAction() {
		return action;
	}
}
