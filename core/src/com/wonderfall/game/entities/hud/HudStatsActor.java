package com.wonderfall.game.entities.hud;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.GameState;

public class HudStatsActor extends Actor {

	Label score;
	Label lives;

	Table container;

	// BitmapFont font;

	public HudStatsActor() {
		Label scoreLabel = new Label("Score:", Assets.skin);
		score = new Label("" + GameState.SCORE, Assets.skin);
		Label livesLabel = new Label("Lives:", Assets.skin);
		lives = new Label("" + GameState.LIVES_LEFT, Assets.skin);

		container = new Table(Assets.skin);
		container.align(Align.left | Align.top);

		container.row();
		container.add(scoreLabel);
		container.add(score);
		container.row();
		container.add(livesLabel);
		container.add(lives);
		

		// font = new BitmapFont();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		container.setPosition(0, getStage().getHeight());
		container.draw(batch, parentAlpha);

		// font.draw(batch, ""+GameState.LIVES_LEFT, 100,
		// getStage().getHeight());
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		score.setText("" + String.format("%.2f", GameState.DIFFICULTY));
		lives.setText("" + GameState.LIVES_LEFT);
	}
}
