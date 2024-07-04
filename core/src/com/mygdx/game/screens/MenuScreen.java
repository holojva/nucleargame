package com.mygdx.game.screens;

import com.mygdx.game.ui.menu.MenuUi;

public class MenuScreen extends BaseScreen{
    MenuUi ui;
    public MenuScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        //ui = new MenuUi(nuclearGame.skin);
        stage.addActor(ui.root);

        //ui.exitButton.addListener(exitButtonClickedListener);
        //ui.startButton.addListener(startButtonClickedListener);
        //ui.settingsButton.addListener(settingsButtonClickedListener);
    }
}
