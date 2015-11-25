package com.wonderfall.game.background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.wonderfall.game.utils.Assets;

public class BackgroundActor extends Actor {
	
	Texture texture;
	
	public BackgroundActor() {
		texture = Assets.background;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(texture, 0, 0, getStage().getWidth(), getStage().getHeight(), 0, 0, texture.getWidth(), texture.getHeight(), false, false);
		
	}
}
