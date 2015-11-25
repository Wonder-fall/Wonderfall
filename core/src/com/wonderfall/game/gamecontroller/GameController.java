package com.wonderfall.game.gamecontroller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.wonderfall.game.entities.shell.ShellActor;
import com.wonderfall.game.screens.LevelScreen;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.GameState;
import com.wonderfall.game.utils.LevelsManager;

/**
 * This class is responsible for managing event handlers from the different
 * actor, for example, player jump event will be executed from the PlayerActor
 * class, but will also run appropriate sound using the sound manager
 * 
 * Events are first executed in the specific actors and then being propagated
 * here
 * 
 * TL;DR all events go through here
 * 
 * @author BarDavid
 *
 */
public class GameController {

	public static void triggerPlayerJump() {

	}

	public static void triggerPlayerMove() {

	}

	public static void triggerEnemySpawn(Actor actor) {

	}

	public static void triggerObjectLoss(Actor actor) {
        ShellActor.hints.showHint(actor.getX(), actor.getY() + 20f,
				Constants.OBJECT_LOSS_WORDS[MathUtils.random(0, Constants.OBJECT_LOSS_WORDS.length - 1)]);
		
		LevelScreen.enemy.removeActor(actor);
	}

	public static void triggerObjectWin(Actor actor) {
		LevelScreen.enemy.removeActor(actor);
	}

    public static void triggerFramePassed() {
    	GameState.TIMER -= Gdx.graphics.getDeltaTime();
        GameState.DIFFICULTY += Gdx.graphics.getDeltaTime() * LevelsManager.curLevel.getDifficulty().getIncreaseOverTime();
    }
}
