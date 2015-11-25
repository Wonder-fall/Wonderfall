package com.wonderfall.game.entities.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.wonderfall.game.entities.BoxedImageActor;
import com.wonderfall.game.utils.Constants;

public class PlayerActor extends BoxedImageActor {

	Vector2 velocity;

	boolean isJumping;
	boolean isDoubleJumping;

	public PlayerActor(Texture texture) {
		super(texture);
		this.velocity = new Vector2(0, 0);

		setPosition(Constants.PLAYER_START_POSITION.x, Constants.PLAYER_START_POSITION.y);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		// handle vertical speed deceleration ( once player hits the floor, init
		// vertical speed )
		if (getY() >= Constants.PLAYER_FLOOR_HEIGHT)
			velocity.y -= delta * Constants.GRAVITATIONAL_ACCELERATION;

		setX(getX() + delta * velocity.x);
		setY(getY() + delta * velocity.y);

		maintainVelocityAndPositionBounds();
	}

	/**
	 * This method ensures the actor position is safely found inside the stage's
	 * viewport. if the player hit the wall, it resets its horizontal velocity
	 * it also resets jumping states(isJumping,isDoubleJumping)
	 */
	private void maintainVelocityAndPositionBounds() {
		if (getX() < 0) {
			setX(0);
			velocity.x *= -0.3;
		}
		if (getX() > getStage().getWidth() - getWidth()) {
			setX(getStage().getWidth() - getWidth());
			velocity.x *= -0.3;
		}

		if (getY() < Constants.PLAYER_FLOOR_HEIGHT) {
			velocity.y = 0;
			isJumping = false;
			isDoubleJumping = false;
			setY(Constants.PLAYER_FLOOR_HEIGHT);
		}
	}

	public void jump() {
		if (!isDoubleJumping) {
			if (!isJumping) // didnt jump yet
				isJumping = true;
			else // jumped once
				isDoubleJumping = true;
			velocity.y += Constants.PLAYER_JUMP_FORCE;
		}
	}

	public void move(float velocityX) {
		if (velocityX > Constants.PLAYER_MAX_VELOCITY)
			velocityX = Constants.PLAYER_MAX_VELOCITY;
		else if (velocityX < -Constants.PLAYER_MAX_VELOCITY)
			velocityX = -Constants.PLAYER_MAX_VELOCITY;
		velocity.x += velocityX * Constants.PLAYER_MOVE_SENSITIVITY;
	}
}
