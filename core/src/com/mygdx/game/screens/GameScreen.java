package com.mygdx.game.screens;

import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.GameScreenUi;

public class GameScreen extends BaseScreen{
    GameScreenUi ui;
    public GameScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new GameScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

    }
}
