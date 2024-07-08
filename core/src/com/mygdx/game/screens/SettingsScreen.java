package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.SettingScreenUi;

public class SettingsScreen extends BaseScreen {

    SettingScreenUi ui;

    public SettingsScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new SettingScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

        ui.music.addListener(musicButtonClickedListener);
        ui.musicSwitch.addListener(musicButtonClickedListener);
        ui.soundSwitch.addListener(soundButtonClickedListener);
        ui.sound.addListener(soundButtonClickedListener);
        ui.exit.addListener(exitButtonClickedListener);

    }
    ClickListener exitButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.menuScreen);
        }
    };
    ClickListener soundButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {

        }
    };
    ClickListener musicButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {

        }
    };
}
