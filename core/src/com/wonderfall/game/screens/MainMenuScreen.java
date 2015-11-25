package com.wonderfall.game.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.forever;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.wonderfall.game.WonderfallGame;
import com.wonderfall.game.background.BackgroundActor;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelsManager;

public class MainMenuScreen implements Screen {

	WonderfallGame game;
	Stage stage;

	public MainMenuScreen(WonderfallGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		stage = new Stage(new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
		Gdx.input.setInputProcessor(stage);

		BackgroundActor background = new BackgroundActor();

		background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		background.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				LevelsManager.setLevel(0);
				game.setScreen(new GameScreen(game));
				return true;
			}

		});

		stage.addActor(background);

		// resizing label actor
		Label hintLbl = new Label("Tap to start", Assets.skin);
		Container<Actor> lblContainer = new Container<Actor>(hintLbl);

		lblContainer.setPosition(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 2);
		lblContainer.setTransform(true);
		lblContainer.addAction(forever(sequence(scaleBy(0.3f, 0.3f, 1f), scaleBy(-0.3f, -0.3f, 1f))));

		stage.addActor(lblContainer);
	}

	@Override
	public void hide() {
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
	public void dispose() {
		// TODO Auto-generated method stub

	}

}