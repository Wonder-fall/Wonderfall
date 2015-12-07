package com.wonderfall.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.wonderfall.game.WonderfallGame;
import com.wonderfall.game.entities.background.BackgroundActor;
import com.wonderfall.game.level.objective.LevelObjective;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelsManager;

public class LevelSelectScreen implements Screen {
	Stage stage;
	WonderfallGame game;
	Table table;
	ArrayList<ImageTextButton> buttonList;

	public LevelSelectScreen(WonderfallGame game) {
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

		buttonList = new ArrayList<ImageTextButton>();

		stage.addActor(background);

		Label title = new Label("Choose a level", new LabelStyle(Assets.font, Color.WHITE));
		Container<Actor> lblContainer = new Container<Actor>(title);

		lblContainer.setPosition(Constants.WORLD_WIDTH / 2, (Constants.WORLD_HEIGHT / 10) * 9);
		lblContainer.setTransform(true);
		lblContainer.scaleBy(1.5f, 1f);

		stage.addActor(lblContainer);

		table = new Table();
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());

		for (int rows = 1; rows < 6; rows++) {
			for (int columns = 1; columns < 5; columns++) {
				addButton((rows - 1) * 4 + columns);
			}
			table.row();
		}
		table.center();

		stage.addActor(table);
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

	public void addButton(final int buttonNumber) {
		if (buttonNumber > 0 && buttonNumber > buttonList.size() && buttonNumber <= LevelsManager.getLevelsAmmount()) {
			Integer num = new Integer(buttonNumber);

			// check if user played this level, and if he does, check if his
			// score is above the bronze/silver/gold requirements
			int lvlScore = Assets.getGameData("level_" + (buttonNumber - 1) + "_score");

			TextureRegion btnTexture;
			// if user played this level
			if (lvlScore > 0) {
				LevelObjective lvlObjective = LevelsManager.getLevel(buttonNumber - 1).getObjective();

				if (lvlScore > lvlObjective.getBronze()) // if player is
															// entitled to
															// bronze
					btnTexture = new TextureRegion(Assets.button_1star);
				else if (lvlScore > lvlObjective.getSilver()) // if player is
																// entitled to
																// silver
					btnTexture = new TextureRegion(Assets.button_2star);
				else if (lvlScore > lvlObjective.getGold()) // if player is
															// entitled to gold
					btnTexture = new TextureRegion(Assets.button_3star);
				else
					btnTexture = new TextureRegion(Assets.button_0star);
			} else {
				btnTexture = new TextureRegion(Assets.button_0star);
			}

			ImageTextButton button = new ImageTextButton(num.toString(),
					new ImageTextButtonStyle(new TextureRegionDrawable(btnTexture), null, null, Assets.font));
			button.align(Align.top).padTop(13f);

			table.add(button).size(64f, 64f).space(0, 0, 14f, 14f);
			buttonList.add(button);
			button.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					LevelsManager.setLevel(buttonNumber - 1);
					game.setScreen(new LevelLoadingScreen(game));
				}
			});
		}
	}
}
