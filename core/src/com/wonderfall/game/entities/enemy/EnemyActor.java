package com.wonderfall.game.entities.enemy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.level.LevelDifficulty;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.GameState;

public class EnemyActor extends Group {

	Sprite sprite;

	ArrayList<Texture> fallingTextures;

	LevelDifficulty difficulty;

	public EnemyActor(Texture texture, LevelDifficulty difficulty) {
		this.sprite = new Sprite(texture);
		this.difficulty = difficulty;

		setPosition(Constants.ENEMY_START_POSITION.x, Constants.ENEMY_START_POSITION.y);

		fallingTextures = new ArrayList<Texture>();
		fallingTextures.add(Assets.throwable1);
		fallingTextures.add(Assets.throwable2);
		fallingTextures.add(Assets.throwable3);
		fallingTextures.add(Assets.throwable4);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		for (Actor child : getChildren()) {
			child.draw(batch, parentAlpha);
		}

		batch.draw(sprite.getTexture(), getX(), getY(), 64f, 64f, 0, 0, sprite.getTexture().getWidth(),
				sprite.getTexture().getHeight(), false, false);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		setBounds(getX(), getY(), sprite.getWidth(), sprite.getHeight());

		GameState.DIFFICULTY += delta * difficulty.getIncreaseOverTime();

		// spawn
		if (!hasActions() && MathUtils.random() < delta * (difficulty.getInitialSpawnRate() * GameState.DIFFICULTY)) {

			Texture newFObjTexture = fallingTextures.get(MathUtils.random(0, fallingTextures.size() - 1));

			Vector2 newFObjPosition = new Vector2(
					MathUtils.random() * (getStage().getWidth() - newFObjTexture.getWidth()),
					getStage().getHeight() - 20f);

			Vector2 newFObjVelocity = new Vector2(0, -(MathUtils.random(difficulty.getInitialObjectsVelocity(),
					difficulty.getInitialObjectsVelocity() + GameState.DIFFICULTY)));

			// generates a new actor with a random texture, random position and
			// random velocity
			final FallingObjectActor newFObjActor = new FallingObjectActor(newFObjTexture, newFObjPosition,
					newFObjVelocity);

			// move for 1sec and spawn an object right away
			addAction(sequence((moveTo(newFObjPosition.x, newFObjPosition.y, difficulty.getInitialSpawnerVelocity())),
					run(new Runnable() {

						@Override
						public void run() {
							addActor(newFObjActor);
							GameController.triggerEnemySpawn(newFObjActor);
						}
					})));
		}

		for (Actor child : getChildren()) {
			child.act(delta);
		}
	}
}
