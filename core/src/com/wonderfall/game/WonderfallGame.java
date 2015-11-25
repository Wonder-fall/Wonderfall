package com.wonderfall.game;

import com.badlogic.gdx.Game;
import com.wonderfall.game.screens.MainMenuScreen;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.LevelsManager;

public class WonderfallGame extends Game {

	@Override
	public void create() {

		Assets.load();
		LevelsManager.loadLevels();

		setScreen(new MainMenuScreen(this));

	}
}
