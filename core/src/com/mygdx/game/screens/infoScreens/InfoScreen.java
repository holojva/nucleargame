package com.mygdx.game.screens.infoScreens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameSettings;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.ui.InfoScreenUi1;

public class InfoScreen extends BaseScreen {
    public InfoScreenUi1 ui;
    GameSettings gameSettings;
    InfoScreen ui1;
    public InfoScreen(NuclearGame nuclearGame, String x, String skin) {
        super(nuclearGame);
        ui = new InfoScreenUi1(nuclearGame.skin, "bilibino-npp", gameSettings.TextInfoScreenOne);
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
