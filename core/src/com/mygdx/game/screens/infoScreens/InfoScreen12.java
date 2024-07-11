package com.mygdx.game.screens.infoScreens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameSettings;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.ui.InfoScreenUi1;

public class InfoScreen12 extends BaseScreen {
    InfoScreenUi1 ui;
    GameSettings gameSettings;
    public boolean updateLvl2 = false;
    public boolean updateLvl3 = false;
    public boolean updateLvl4 = false;

    public InfoScreen12(NuclearGame nuclearGame, String text, String skin) {
        super(nuclearGame);
        ui = new InfoScreenUi1(nuclearGame.skin, skin, text);
        stage.addActor(ui.root);
        stage.addListener(gameStartClickedListener);
    }

    ClickListener gameStartClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            // nuclearGame.levelsScreen.ui.updateNpp3(updateLvl3);
            // nuclearGame.levelsScreen.ui.updateNpp4(updateLvl4);
            // nuclearGame.levelsScreen.ui.updateNpp2(updateLvl2);
            nuclearGame.setScreen(nuclearGame.levelsScreen);
        }
    };
}
