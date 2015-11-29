package com.wonderfall.game.gamecontroller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.GameState;
import com.wonderfall.game.utils.LevelState;
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
		//play some sound..
	}

	public static void triggerObjectWin(Actor actor) {
		//play some sound..
	}

	public static void triggerFramePassed() {

		LevelState.TIMER -= Gdx.graphics.getDeltaTime();
		if (LevelState.TIMER <= 0)
			triggerGameEnd();

		LevelState.DIFFICULTY += Gdx.graphics.getDeltaTime()
				* LevelsManager.curLevel.getDifficulty().getIncreaseOverTime();

	}

	public static void triggerGamePaused() {
		LevelState.IS_PAUSED = true;
	}

	public static void triggerGameResumed() {
		LevelState.IS_PAUSED = false;
	}

	/**
	 * Called on game end due to time or object hit.
	 */
	public static void triggerGameEnd() {
		if (LevelState.TIMER <= 0) {// game ended due to time elapsed
			System.exit(0);
		} else {// game ended due to object hit
			System.exit(0);
		}
	}
	
	public static void triggerTimeSlow()
	{
		if (GameState.specials.get("timeslow") > 0 && !LevelState.IS_TIME_SLOWED)
		{
			GameState.specials.put("timeslow", GameState.specials.get("timeslow") - 1);
			LevelState.IS_TIME_SLOWED = true;
			
			Timer timer = new Timer();
			timer.scheduleTask(new Timer.Task() {
				
				@Override
				public void run() {
					LevelState.IS_TIME_SLOWED = false;
					
				}

				@Override
				public void cancel() {
					// TODO Auto-generated method stub
					
				}
			}, Constants.OBJECT_TIME_SLOW_DURATION);
			timer.start();
			//play some funky sound 
		}
	}
}
