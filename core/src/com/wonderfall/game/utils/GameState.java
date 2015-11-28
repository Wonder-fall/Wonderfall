package com.wonderfall.game.utils;

import java.util.HashMap;

public class GameState {
	
	//maps between levels.json specialty object name and player's amount so far
	public static HashMap<String,Integer> specials = new HashMap<String, Integer>();
	
	public static void loadGameState()
	{
		specials.put("timeslow", 0);
		specials.put("nuke", 0);
	}
}