package com.wonderfall.game.entities.shell.hud;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.wonderfall.game.utils.Assets;

public class HudEventHintActor extends Group {

	public HudEventHintActor() {

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		for (Actor child : getChildren()) {
			child.draw(batch, parentAlpha);
		}
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		for (Actor child : getChildren()) {
			child.act(delta);
		}
	}

	public void showHint(float x, float y, CharSequence hint) {
		// instances a new hint label because there can be a dynamic number of
		// labels on the screen at the same time
		Label hintLabel = new Label(hint, Assets.skin);
		//arbitrary position for now TODO
		hintLabel.setPosition(x, y + 15f);
		//TODO: FIND THE RIGHT ACTION TO DISPLAY THE LABEL
		hintLabel.addAction(fadeOut(1.5f));

		addActor(hintLabel);
	}
}
