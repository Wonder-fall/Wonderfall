package com.wonderfall.game.entities.player;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelState;

public class PlayerTouchHandlerActor extends Actor {

	PlayerActor player;

	public PlayerTouchHandlerActor(final PlayerActor player) {

		this.player = player;

		setBounds(Constants.PLAYER_TOUCH_AREA.x, Constants.PLAYER_TOUCH_AREA.y, Constants.PLAYER_TOUCH_AREA.width,
				Constants.PLAYER_TOUCH_AREA.height);

		this.addListener(new ActorGestureListener() {

			@Override
			public void fling(InputEvent event, float velocityX, float velocityY, int button) {
                if (!LevelState.IS_PAUSED) {
                    player.move(velocityX);
                }
			}

			@Override
			public void tap(InputEvent event, float x, float y, int count, int button) {
                if (!LevelState.IS_PAUSED) {
                    player.jump();
                }
			}
		});
	}
}
