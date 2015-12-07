package com.wonderfall.game.entities.shell.inventory.usable;

import com.badlogic.gdx.utils.Timer;
import com.wonderfall.game.entities.shell.ShellActor;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelState;

public class UsableSlowTime extends UsableItemBtnActor {

	public UsableSlowTime(ImageTextButtonStyle style) {
		super("", style);
	}

	@Override
	public void useItem() {

		if (Assets.getGameData("timeslow") > 0 && !LevelState.IS_TIME_SLOWED) {

			Assets.setGameData("timeslow", Assets.getGameData("timeslow") - 1);

			LevelState.IS_TIME_SLOWED = true;
			LevelState.TIME_SLOW_LEFT = Constants.OBJECT_TIME_SLOW_DURATION;

			Timer timer = new Timer();

			timer.scheduleTask(new Timer.Task() {

				@Override
				public void run() {
					ShellActor.hints.showHint(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 1.5f,
							"" + LevelState.TIME_SLOW_LEFT, 0.7f);
					if (LevelState.TIME_SLOW_LEFT <= 0)
						LevelState.IS_TIME_SLOWED = false;
					LevelState.TIME_SLOW_LEFT--;
				}
			}, 0, 1, Constants.OBJECT_TIME_SLOW_DURATION);

			timer.start();
			// play some funky sound
		}

	}

}
