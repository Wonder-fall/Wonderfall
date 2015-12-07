package com.wonderfall.game.entities.shell.inventory;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.wonderfall.game.entities.shell.inventory.usable.UsableSlowTime;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;

public class InventoryActor extends Group {

	Table table;

	// ImageTextButton timeBtn;
	UsableSlowTime timeBtn;
	ImageTextButton nukeBtn;

	public InventoryActor() {

		HorizontalGroup group = new HorizontalGroup();
		group.setTouchable(Touchable.enabled);

		group.reverse();
		group.setSize(Constants.WORLD_WIDTH, 64f);

		/*
		 * group.addActor(new ImageTextButton("", new ImageTextButtonStyle( new
		 * TextureRegionDrawable(new TextureRegion(Assets.button_unknown)),
		 * null, null, font))); group.addActor(new ImageTextButton("", new
		 * ImageTextButtonStyle( new TextureRegionDrawable(new
		 * TextureRegion(Assets.button_unknown)), null, null, font)));
		 * group.addActor(new ImageTextButton("", new ImageTextButtonStyle( new
		 * TextureRegionDrawable(new TextureRegion(Assets.button_unknown)),
		 * null, null, font))); group.addActor(new ImageTextButton("", new
		 * ImageTextButtonStyle( new TextureRegionDrawable(new
		 * TextureRegion(Assets.button_unknown)), null, null, font)));
		 * group.addActor(new ImageTextButton("", new ImageTextButtonStyle( new
		 * TextureRegionDrawable(new TextureRegion(Assets.button_unknown)),
		 * null, null, font))); group.addActor(new ImageTextButton("", new
		 * ImageTextButtonStyle( new TextureRegionDrawable(new
		 * TextureRegion(Assets.button_unknown)), null, null, font)));
		 * group.addActor(new ImageTextButton("", new ImageTextButtonStyle( new
		 * TextureRegionDrawable(new TextureRegion(Assets.button_unknown)),
		 * null, null, font)));
		 */

		nukeBtn = new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.throwable_nuke)), null, null, Assets.font));
		nukeBtn.align(Align.topRight);
		group.addActor(nukeBtn);

		timeBtn = new UsableSlowTime(new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.throwable_time)), null, null, Assets.font));
		
		timeBtn.align(Align.topRight);

		Container<Actor> timeBtnContainer = new Container<Actor>(timeBtn).height(64f).width(64f);
		group.addActor(timeBtnContainer);

		ScrollPane pane = new ScrollPane(group, Assets.skin);

		pane.setScrollingDisabled(false, true);
		pane.setForceScroll(true, false);
		pane.setupFadeScrollBars(0f, 0f);

		pane.setBounds(0, 0, Constants.WORLD_WIDTH, 64f);
		pane.setTouchable(Touchable.enabled);

		addActor(pane);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		nukeBtn.setText("" + Assets.getGameData("nuke"));
		timeBtn.setText("" + Assets.getGameData("timeslow"));

	}
}
