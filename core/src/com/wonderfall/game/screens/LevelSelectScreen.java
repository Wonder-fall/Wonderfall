package com.wonderfall.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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
    Table table;
    ArrayList<TextButton> buttonList;

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

        buttonList = new ArrayList<TextButton>();

        stage.addActor(background);

        Label title = new Label("Choose a level", Assets.skin);
        Container<Actor> lblContainer = new Container<Actor>(title);

        lblContainer.setPosition(Constants.WORLD_WIDTH / 2, (Constants.WORLD_HEIGHT / 10) * 9);
        lblContainer.setTransform(true);
        lblContainer.scaleBy(1.5f, 1f);

        stage.addActor(lblContainer);


        table = new Table();
        table.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        for(int rows = 1; rows<6;rows++)
        {
            for(int columns = 1;columns<5;columns++)
            {
                addButton((rows-1)*4+columns);
            }
            table.row();
        }
        buttonList.get(2).setDisabled(true);
        table.center();

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
    public void addButton(final int buttonNumber)
    {
        if(buttonNumber>0&&buttonNumber>buttonList.size()&&buttonNumber<=LevelsManager.getLevelsAmmount()) {
            Integer num = new Integer(buttonNumber);
            TextButton button = new TextButton(num.toString(), Assets.skin);
            table.add(button).size(64f, 64f).space(0,0,36f,36f);
            buttonList.add(button);
            button.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    LevelsManager.setLevel(buttonNumber - 1);
                    game.setScreen(new MainMenuScreen(game));
                }
            });
        }
    }
}
