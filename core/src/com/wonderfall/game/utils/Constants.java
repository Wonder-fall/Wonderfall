package com.wonderfall.game.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Constants {

	public static final float WORLD_WIDTH = 480f;
	public static final float WORLD_HEIGHT = 800f;

	// THE FORCE USED ON THE PLAYER AFTER HE JUMPS
	public static final float GRAVITATIONAL_ACCELERATION = 240f;

	// THE MULTIPLIER USED ON THE MOBILE FLING EVENT
	public static final float PLAYER_MOVE_SENSITIVITY = 0.15f;
	// VELOCITY FACTOR TO PREVENT FAST SWIPE ABUSE
	public static final float PLAYER_MAX_VELOCITY = 1500f;
	// THE INITIAL KICK THE PLAYER GETS WHEN HE JUMPS
	public static final float PLAYER_JUMP_FORCE = 135.0f;
	// THE HEIGHT OFFSET FROM THE BOTTOM OF THE SCREEN WHICH THE PLAYER SPAWNS
	public static final float PLAYER_FLOOR_HEIGHT = 75.0f;
	// THE PLAYER INITIAL DRAWING POSITION
	public static final Vector2 PLAYER_START_POSITION = new Vector2(WORLD_WIDTH / 2, PLAYER_FLOOR_HEIGHT);
	// THE FORCE IN WHICH IS MULTIPLIED BY THE VELOCITY.X ONCE THE PLAYER HIT
	// THE WALL
	public static final float PLAYER_BOUNCE_FORCE = -0.3f;
	// THE TOUCH AREA USED FOR TAP(JUMP)/FLING(MOVE) OF THE PLAYER
	public static final Rectangle PLAYER_TOUCH_AREA = new Rectangle(0, PLAYER_FLOOR_HEIGHT, WORLD_WIDTH,
			PLAYER_FLOOR_HEIGHT + 400f);

	public static final String[] OBJECT_LOSS_WORDS = new String[] { "Shit!", "Damn!", "Ouch!", "****!!", "ARGGG!!!" };
	// THE ENEMY INITIAL DRAWING POSITION
	public static final Vector2 ENEMY_START_POSITION = new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT);
	// THE FACTOR IN WHICH THE OBJECTS WILL BE SLOWED WHILE PLAYER USED TIME SLOW
	public static final float OBJECT_TIME_SLOW_FACTOR = 0.2f;
	public static final int OBJECT_TIME_SLOW_DURATION = 5;

	public static final int INITIAL_SCORE = 0;
	public static final float INITIAL_DIFFICULTY = 0.0f;
}
