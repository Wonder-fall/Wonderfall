package com.wonderfall.game.level.entities;

import java.util.ArrayList;

import com.wonderfall.game.level.entities.objects.LevelBadObject;
import com.wonderfall.game.level.entities.objects.LevelGoodObject;
import com.wonderfall.game.level.entities.objects.LevelSpecialObject;
/**
 * 
 * @author BarDavid
 *
 */
public class LevelEntities {

	private String background;
	private int goodRatio;
	private int badRatio;
	private int specialRatio;
	private ArrayList<LevelGoodObject> goodObjects;
	private ArrayList<LevelBadObject> badObjects;
	private ArrayList<LevelSpecialObject> specialObjects;

	public String getBackground() {
		return background;
	}

	public int getGoodRatio() {
		return goodRatio;
	}

	public int getBadRatio() {
		return badRatio;
	}

	public int getSpecialRatio() {
		return specialRatio;
	}
	
	public ArrayList<LevelGoodObject> getGoodObjects() {
		return goodObjects;
	}

	public ArrayList<LevelBadObject> getBadObjects() {
		return badObjects;
	}

	public ArrayList<LevelSpecialObject> getSpecialObjects() {
		return specialObjects;
	}
}
