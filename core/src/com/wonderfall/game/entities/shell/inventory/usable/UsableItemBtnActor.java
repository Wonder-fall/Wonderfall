package com.wonderfall.game.entities.shell.inventory.usable;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class UsableItemBtnActor extends ImageTextButton {

	public UsableItemBtnActor(String text, ImageTextButtonStyle style) {
		super(text, style);

		this.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				// uses the item
				useItem();
			}
		});
	}

	public abstract void useItem();
}
