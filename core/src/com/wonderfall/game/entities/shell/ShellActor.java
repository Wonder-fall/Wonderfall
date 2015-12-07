package com.wonderfall.game.entities.shell;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.wonderfall.game.WonderfallGame;
import com.wonderfall.game.entities.shell.backdrop.BackdropActor;
import com.wonderfall.game.entities.shell.hud.HudEventHintActor;
import com.wonderfall.game.entities.shell.hud.HudStatsActor;
import com.wonderfall.game.entities.shell.inventory.InventoryActor;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.LevelState;

public class ShellActor extends Group {
    Actor self = this;
    Table container;
    static Button pauseButton;
    public static HudStatsActor stats;
    public static HudEventHintActor hints;
    public static InventoryActor inventory;
    public static BackdropActor backdrop;
    WonderfallGame game;

    public ShellActor(WonderfallGame g) {
        game = g;
        stats = new HudStatsActor();
        hints = new HudEventHintActor();
        inventory = new InventoryActor();
        
        this.addActor(stats);
        this.addActor(hints);
        this.addActor(inventory);

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
                if (!LevelState.IS_PAUSED) {
                    backdrop.setVisible(true);
                }
            }
        });

        addActor(container);

        backdrop = new BackdropActor(game);
        backdrop.setVisible(false);
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
