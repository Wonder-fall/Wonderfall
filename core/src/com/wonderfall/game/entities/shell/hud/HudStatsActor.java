package com.wonderfall.game.entities.shell.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelState;

public class HudStatsActor extends Actor {

	Label score;
	Label timeLeft;

	Table container;

	public HudStatsActor() {
		Label scoreLabel = new Label("Score:", new LabelStyle(Assets.font, Color.WHITE));
		score = new Label("" + LevelState.SCORE, new LabelStyle(Assets.font, Color.WHITE));
		Label timeLeftLabel = new Label("Time Left:", new LabelStyle(Assets.font, Color.WHITE));
		timeLeft = new Label("" + LevelState.TIMER, new LabelStyle(Assets.font, Color.WHITE));

		container = new Table(Assets.skin);
		container.align(Align.topLeft);

		container.add(scoreLabel).align(Align.left);
		container.add(score);
		container.row();
		container.add(timeLeftLabel).align(Align.left);
		container.add(timeLeft);

		container.setPosition(0, Constants.WORLD_HEIGHT);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		container.draw(batch, parentAlpha);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		score.setText("" + (int) LevelState.SCORE);
		timeLeft.setText("" + (int) LevelState.TIMER);
	}
}
