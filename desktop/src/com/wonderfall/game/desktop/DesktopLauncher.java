package com.wonderfall.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.wonderfall.game.WonderfallGame;
import com.wonderfall.game.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) Constants.WORLD_WIDTH;
		config.height = (int) Constants.WORLD_HEIGHT;
		new LwjglApplication(new WonderfallGame(), config);
	}
}
