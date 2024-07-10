package com.mygdx.game.screens;

import com.mygdx.game.NuclearGame;

public class SparklingWaterScreen extends BaseScreen {
    SparklingWaterScreenUi ui;
    public SparklingWaterScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new SparklingWaterScreenUi(nuclearGame.skin);

        stage.addActor(ui.root);

    }
}
