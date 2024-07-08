package com.mygdx.game.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.InfoScreenUi;

public class InfoScreen extends BaseScreen {
    InfoScreenUi ui;
    public InfoScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new InfoScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

        stage.addListener(gameStartClickedListener);
    }
    ClickListener gameStartClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.gameScreen);
        }
    };
}
