package com.wonderfall.game.entities.enemy.fallingobject;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.wonderfall.game.entities.BoxedImageActor;
import com.wonderfall.game.screens.LevelScreen;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelState;

public abstract class CommonFallingObject extends BoxedImageActor implements IFallingObject {

	protected Vector2 velocity;

	private boolean isOnFloor = false;

	public CommonFallingObject(Texture texture, Vector2 initialPosition, Vector2 velocity) {
		super(texture);
		// x y of the actor
		setX(initialPosition.x);
		setY(initialPosition.y);

		this.velocity = velocity;
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		if (!isOnFloor) {
			if (!LevelState.IS_TIME_SLOWED) {
				setX(getX() + delta * velocity.x);
				setY(getY() + delta * velocity.y);
			} else {
				setX(getX() + delta * velocity.x * Constants.OBJECT_TIME_SLOW_FACTOR);
				setY(getY() + delta * velocity.y * Constants.OBJECT_TIME_SLOW_FACTOR);
			}

			// if hit player
			if (this.isCollidedWith(LevelScreen.player.getBoundingBox()))
				playerCollision();

			// if hit floor
			else if (this.getY() < Constants.PLAYER_FLOOR_HEIGHT) {
				isOnFloor = true;
				// stops the motion
				velocity.setZero();
				// fade out action and then remove the actor
				addAction(sequence(fadeOut(1f), run(new Runnable() {

					@Override
					public void run() {
						// remove actor from its group
						remove();
					}
				})));
				// specific object floor collision implementation
				floorCollision();
			}
		}
	}
}
