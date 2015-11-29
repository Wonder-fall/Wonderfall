package com.wonderfall.game.entities.shell.backdrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.screens.LevelSelectScreen;
import com.wonderfall.game.utils.Assets;

public class BackdropActor extends Group {

    Table container;
    private ShapeRenderer shapeRenderer;
    static boolean projectionMatrixSet;
    static Button resumeButton;
    static Button backButton;
    Actor self = this;
    WonderfallGame game;

    public BackdropActor(WonderfallGame g) {
        game = g;
        shapeRenderer = new ShapeRenderer();
        projectionMatrixSet = false;

        resumeButton = new ImageButton(new SpriteDrawable(new Sprite(Assets.resume)));
        backButton = new ImageButton(new SpriteDrawable(new Sprite(Assets.back)));

        container = new Table(Assets.skin);
        container.align(Align.center);
        container.row();

        container.add(resumeButton);
        container.add(backButton);

        container.setTouchable(Touchable.childrenOnly);
        resumeButton.setTouchable(Touchable.enabled);
        backButton.setTouchable(Touchable.enabled);

        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                self.setVisible(false);
                GameController.triggerGameResumed();
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                self.setVisible(false);
                GameController.triggerGameResumed();
                game.setScreen(new LevelSelectScreen(game));
            }
        });

        addActor(container);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        if(!projectionMatrixSet){
            shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(0, 0, 0, 0.7f));
        shapeRenderer.rect(0, 0, getStage().getWidth(), getStage().getHeight());
        shapeRenderer.end();
        batch.begin();

        container.setPosition(getStage().getWidth() / 2, getStage().getHeight()/ 2);
        container.draw(batch, parentAlpha);
    }
}