package com.wonderfall.game.entities.enemy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.level.difficulty.LevelDifficulty;
import com.wonderfall.game.level.entities.objects.LevelObject;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelState;

public class EnemyActor extends Group {

	Sprite sprite;

	FallingObjectGenerator generator;
	LevelDifficulty difficulty;

	public EnemyActor(Texture texture, LevelDifficulty difficulty) {
		this.sprite = new Sprite(texture);
		this.difficulty = difficulty;
		this.generator = new FallingObjectGenerator();

		setPosition(Constants.ENEMY_START_POSITION.x, Constants.ENEMY_START_POSITION.y);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		batch.draw(sprite.getTexture(), getX(), getY(), 64f, 64f, 0, 0, sprite.getTexture().getWidth(),
				sprite.getTexture().getHeight(), false, false);

		drawChildren(batch, parentAlpha);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		setBounds(getX(), getY(), sprite.getWidth(), sprite.getHeight());

		// spawn
		if (!hasActions() && MathUtils.random() < delta * (difficulty.getInitialSpawnRate() * LevelState.DIFFICULTY)) {
//just a note
			LevelObject levelObj = generator.generate();

			Texture newFObjTexture = Assets.entitiesMap.get(levelObj.getTexture());

			Vector2 newFObjPosition = new Vector2(
					MathUtils.random() * (getStage().getWidth() - newFObjTexture.getWidth()),
					getStage().getHeight() - 20f);

			Vector2 newFObjVelocity = new Vector2(0, -(MathUtils.random(difficulty.getInitialObjectsVelocity(),
					difficulty.getInitialObjectsVelocity() + LevelState.DIFFICULTY)));
			
			// generates a new actor with a random texture, random position and
			// random velocity
			final FallingObjectActor newFObjActor = new FallingObjectActor(newFObjTexture, newFObjPosition,
					newFObjVelocity);

			// IMPORTANT: THIS LINKS BETWEEN THE ACTOR AND ITS LEVEL
			// CONFIGURATION (FOR SCORE FETCH PURPOSES)
			newFObjActor.setUserObject(levelObj);
			
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
	}
}
