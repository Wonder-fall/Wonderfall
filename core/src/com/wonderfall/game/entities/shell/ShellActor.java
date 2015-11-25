package com.wonderfall.game.entities.shell;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.wonderfall.game.entities.shell.hud.HudEventHintActor;
import com.wonderfall.game.entities.shell.hud.HudStatsActor;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.utils.Assets;

public class ShellActor extends Group {

    Table container;
    static Button pauseButton;
    public static HudStatsActor stats;
    public static HudEventHintActor hints;

    public ShellActor() {
        stats = new HudStatsActor();
        hints = new HudEventHintActor();

        this.addActor(stats);
        this.addActor(hints);

        pauseButton = new ImageButton(new SpriteDrawable(new Sprite(Assets.pause)));

        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GameController.triggerGamePaused();
            }
        });

        container = new Table(Assets.skin);
        container.row();
        container.add(pauseButton);
        container.align(Align.topRight);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        container.setPosition(getStage().getWidth(),getStage().getHeight());
        container.draw(batch, parentAlpha);
    }
}
