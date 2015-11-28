package com.wonderfall.game.level.entities.objects;

public class LevelGoodObject extends LevelObject {

	private int score;

	public LevelGoodObject(String texture, int ratio, int score) {
		super(texture, ratio);
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}
