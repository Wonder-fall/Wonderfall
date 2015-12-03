package com.wonderfall.game.entities.enemy.fallingobject.bad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.wonderfall.game.entities.enemy.fallingobject.CommonFallingObject;
import com.wonderfall.game.gamecontroller.GameController;

public class BadFallingObject extends CommonFallingObject {

	public BadFallingObject(Texture texture, Vector2 initialPosition, Vector2 velocity) {
		super(texture, initialPosition, velocity);
	}

	@Override
	public void playerCollision() {
		// handle the event
		GameController.triggerGameEnd();
		// remove actor from its group
		this.remove();
	}

	@Override
	public void floorCollision() {
		
	}

}
