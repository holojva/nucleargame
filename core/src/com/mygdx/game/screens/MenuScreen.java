package com.mygdx.game.screens;

import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.MenuScreenUi;

public class MenuScreen extends BaseScreen{
    MenuScreenUi ui;
    public MenuScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        //ui = new MenuUi(nuclearGame.skin);
        stage.addActor(ui.root);

        //ui.exitButton.addListener(exitButtonClickedListener);
        //ui.startButton.addListener(startButtonClickedListener);
        //ui.settingsButton.addListener(settingsButtonClickedListener);
    }
}
