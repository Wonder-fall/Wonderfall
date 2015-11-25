package com.wonderfall.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.wonderfall.game.WonderfallGame;
import com.wonderfall.game.entities.background.BackgroundActor;
import com.wonderfall.game.gamecontroller.GameController;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.Constants;
import com.wonderfall.game.utils.LevelsManager;

import java.util.ArrayList;

public class LevelSelectScreen implements Screen
{
    Stage stage;
    WonderfallGame game;

    public LevelSelectScreen(WonderfallGame game)
    {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        BackgroundActor background = new BackgroundActor();

        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        ArrayList<TextButton> buttonList = new ArrayList<TextButton>();
        stage.addActor(background);

        TextButton button = new TextButton("1", Assets.skin);
        Table table = new Table();
        table.add(button);
        buttonList.add(button);
        table.setBounds(0, 0, stage.getWidth() / 2, stage.getHeight() / 2);

        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                LevelsManager.setLevel(0);
                game.setScreen(new MainMenuScreen(game));
            }
        });
        TextButton button2 = new TextButton("2", Assets.skin);
        table.add(button2);
        buttonList.add(button2);
        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                LevelsManager.setLevel(1);
                game.setScreen(new MainMenuScreen(game));
            }
        });
        TextButton button3 = new TextButton("3", Assets.skin);
        table.add(button3);
        buttonList.add(button3);
        button3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                LevelsManager.setLevel(2);
                game.setScreen(new MainMenuScreen(game));
            }
        });
        table.center();
        table.align(Align.center);
        stage.addActor(table);
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }
}
