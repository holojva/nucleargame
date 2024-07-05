package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.LevelsScreenUi;

public class LevelsScreen extends BaseScreen{
    LevelsScreenUi ui;
    public LevelsScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new LevelsScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

        ui.exit.addListener(exitButtonClickedListener);
    }

    ClickListener exitButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.menuScreen);
        }
    };
}
