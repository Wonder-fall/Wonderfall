package com.wonderfall.game.entities.shell.inventory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.GameState;

public class InventoryActor extends Group {

	Table table;

	// ImageTextButton timeBtn;
	ImageTextButton timeBtn;
	ImageTextButton nukeBtn;

	public InventoryActor() {

		HorizontalGroup group = new HorizontalGroup();
		group.setTouchable(Touchable.enabled);

		group.reverse();
		group.setSize(Constants.WORLD_WIDTH, 64f);

		// the font for the item count
		BitmapFont font = new BitmapFont();
		font.setColor(Color.FIREBRICK);

		/*group.addActor(new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.button_unknown)), null, null, font)));
		group.addActor(new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.button_unknown)), null, null, font)));
		group.addActor(new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.button_unknown)), null, null, font)));
		group.addActor(new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.button_unknown)), null, null, font)));
		group.addActor(new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.button_unknown)), null, null, font)));
		group.addActor(new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.button_unknown)), null, null, font)));
		group.addActor(new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.button_unknown)), null, null, font)));*/

		nukeBtn = new ImageTextButton("", new ImageTextButtonStyle(
				new TextureRegionDrawable(new TextureRegion(Assets.throwable_nuke)), null, null, font));
		nukeBtn.align(Align.topRight);
		group.addActor(nukeBtn);

		//TODO: FIX
		Sprite timeBtnSprite = new Sprite(Assets.throwable_time, Assets.throwable_time.getWidth(),
				Assets.throwable_time.getHeight());
		
		timeBtn = new ImageTextButton("",
				new ImageTextButtonStyle(new TextureRegionDrawable(timeBtnSprite), null, null, font));
		timeBtn.align(Align.topRight);

		timeBtn.setTouchable(Touchable.enabled);
		timeBtn.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				GameController.triggerTimeSlow();
			}

		});

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
		
		nukeBtn.setText("" + GameState.specials.get("nuke"));
		timeBtn.setText("" + GameState.specials.get("timeslow"));
		
		
	}
}
