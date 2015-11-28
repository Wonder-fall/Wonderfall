package com.wonderfall.game.level.entities;

import java.util.ArrayList;

import com.wonderfall.game.level.entities.objects.LevelBadObject;
import com.wonderfall.game.level.entities.objects.LevelGoodObject;

public class LevelEntities {

	private String background;
	private int goodRatio;
	private int badRatio;
	private ArrayList<LevelGoodObject> goodObjects;
	private ArrayList<LevelBadObject> badObjects;

	public String getBackground() {
		return background;
	}

	public int getGoodRatio() {
		return goodRatio;
	}

	public int getBadRatio() {
		return badRatio;
	}

	public ArrayList<LevelGoodObject> getGoodObjects() {
		return goodObjects;
	}

	public ArrayList<LevelBadObject> getBadObjects() {
		return badObjects;
	}

}
