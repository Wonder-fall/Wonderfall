package com.wonderfall.game;

import com.badlogic.gdx.Game;
import com.wonderfall.game.screens.LevelSelectScreen;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.GameState;
import com.wonderfall.game.utils.LevelsManager;

/**
 * 
 * Wonderfall game.
 * 
 * @version 1.0
 *
 */
public class WonderfallGame extends Game {

	@Override
	public void create() {

		Assets.load();
		LevelsManager.loadLevels();
		GameState.loadGameState();
		
		setScreen(new LevelSelectScreen(this));

	}
}
