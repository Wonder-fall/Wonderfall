package com.wonderfall.game.entities.enemy.fallingobject.good;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.wonderfall.game.entities.enemy.fallingobject.CommonFallingObject;
import com.wonderfall.game.entities.shell.ShellActor;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelState;

public class GoodFallingObject extends CommonFallingObject {

	// the score increment defined at the JSON file for this object
	protected int score;

	public GoodFallingObject(Texture texture, Vector2 initialPosition, Vector2 velocity, int score) {
		super(texture, initialPosition, velocity);
		this.score = score;
	}

	@Override
	public void playerCollision() {
		// handle the event
		LevelState.SCORE += score;
		// remove actor from its group
		this.remove();
		// propagate to GameController
		GameController.triggerObjectWin(this);
	}

	@Override
	public void floorCollision() {
		// handle the event
		ShellActor.hints.showHint(this.getX(), this.getY() + 20f,
				Constants.OBJECT_LOSS_WORDS[MathUtils.random(0, Constants.OBJECT_LOSS_WORDS.length - 1)], 1.5f);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
