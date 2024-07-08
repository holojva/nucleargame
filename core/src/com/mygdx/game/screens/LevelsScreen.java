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
        ui.level1.addListener(levelOneButtonClickedListener);
        ui.level2.addListener(levelOneButtonClickedListener);
        ui.level3.addListener(levelOneButtonClickedListener);
        ui.level4.addListener(levelOneButtonClickedListener);
    }

    ClickListener exitButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.menuScreen);
        }
    };
    ClickListener levelOneButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {

        }
    };
}
