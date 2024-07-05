package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.NuclearGame;

public class BaseScreen {
    Stage stage;
    NuclearGame nuclearGame;
    public BaseScreen(NuclearGame nuclearGame) {
        this.nuclearGame = nuclearGame;
        if (nuclearGame.viewport != null)  stage = new Stage(nuclearGame.viewport);
    }
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, false);
    }
    public void render(float delta) {
        ScreenUtils.clear(Color.GRAY);
        stage.act(delta);
        stage.draw();
        handleInput();
    }

    public void handleInput() {}
}
