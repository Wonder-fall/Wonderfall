package com.wonderfall.game.entities.shell;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.wonderfall.game.entities.shell.backdrop.BackdropActor;
import com.wonderfall.game.entities.shell.hud.HudEventHintActor;
import com.wonderfall.game.entities.shell.hud.HudStatsActor;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.GameState;

public class ShellActor extends Group {

    Table container;
    static Button pauseButton;
    public static HudStatsActor stats;
    public static HudEventHintActor hints;
    public static BackdropActor backdrop;

    public ShellActor() {
        stats = new HudStatsActor();
        hints = new HudEventHintActor();

        this.addActor(stats);
        this.addActor(hints);

        pauseButton = new ImageButton(new SpriteDrawable(new Sprite(Assets.pause)));

        container = new Table(Assets.skin);
        container.row();
        container.add(pauseButton);
        container.align(Align.topRight);
        container.setTouchable(Touchable.enabled);
        pauseButton.setTouchable(Touchable.enabled);

        container.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!GameState.IS_PAUSED) {
                    GameController.triggerGamePaused();
                    backdrop.setVisible(true);
                }
            }
        });

        addActor(container);

        backdrop = new BackdropActor();
        backdrop.setVisible(false);
        backdrop.setZIndex(container.getZIndex() + 1);
        this.addActor(backdrop);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        container.setPosition(getStage().getWidth(), getStage().getHeight());
        container.draw(batch, parentAlpha);

        if (backdrop.isVisible()) {
            // Make sure the backdrop is topmost
            backdrop.draw(batch, parentAlpha);
        }
    }
}
