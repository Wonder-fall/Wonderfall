package com.wonderfall.game.enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.wonderfall.game.entities.BoxedImageActor;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.screens.GameScreen;
import com.wonderfall.game.utils.Constants;

public class FallingObjectActor extends BoxedImageActor {

	Vector2 velocity;

	public FallingObjectActor(Texture texture, Vector2 initialPosition, Vector2 velocity) {
		super(texture);
		// x y of the actor
		setX(initialPosition.x);
		setY(initialPosition.y);

		this.velocity = velocity;
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		setX(getX() + delta * velocity.x);
		setY(getY() + delta * velocity.y);

		// if hit player
		if (this.isCollidedWith(GameScreen.player.getBoundingBox())) {
			GameController.triggerObjectWin(this);
		}
		// if hit floor
		else if (this.getY() < Constants.PLAYER_FLOOR_HEIGHT) {
			GameController.triggerObjectLoss(this);
		}
	}
}
