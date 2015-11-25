package com.wonderfall.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.wonderfall.game.WonderfallGame;
import com.wonderfall.game.background.BackgroundActor;
import com.wonderfall.game.enemy.EnemyActor;
import com.wonderfall.game.hud.HudEventHintActor;
import com.wonderfall.game.hud.HudStatsActor;
import com.wonderfall.game.player.PlayerActor;
import com.wonderfall.game.player.PlayerTouchHandlerActor;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.GameState;
import com.wonderfall.game.utils.LevelsManager;

public class GameScreen implements Screen {

	WonderfallGame game;
	Stage stage;

	GameState gameState;

	public static PlayerActor player;
	public static HudStatsActor hudStats;
	public static HudEventHintActor hudHints;
	public static BackgroundActor bg;
	public static EnemyActor enemy;

	public GameScreen(WonderfallGame game) {
		this.game = game;
		this.gameState = new GameState(LevelsManager.curLevel.getDifficulty().getInitialLives());
	}

	@Override
	public void show() {
		stage = new Stage(new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
		
		Gdx.input.setInputProcessor(stage);

		player = new PlayerActor(Assets.player);
		enemy = new EnemyActor(Assets.enemy, LevelsManager.curLevel.getDifficulty());
		hudStats = new HudStatsActor();
		hudHints = new HudEventHintActor();
		bg = new BackgroundActor();

		// background
		stage.addActor(bg);

		// player
		stage.addActor(player);
		stage.addActor(new PlayerTouchHandlerActor(player));
		
		// enemy spawner (group)
		stage.addActor(enemy);

		// HUD
		stage.addActor(hudStats);
		stage.addActor(hudHints);
	}

	@Override
	public void render(float delta) {
		//Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
