package com.mygdx.game.screens;

import static com.mygdx.game.GameSettings.TextInfoScreenOne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.screens.infoScreens.InfoScreen12;
import com.mygdx.game.ui.InfoScreenUi1;
import com.mygdx.game.ui.LevelsScreenUi;

public class LevelsScreen extends BaseScreen {
    public LevelsScreenUi ui;
    GameScreen gameScreen;
    NuclearGame nuke;
    SettingsScreen settingsScreen;
    LevelsScreenUi levelsScreenui;
    InfoScreen12 infoScreen12;

    public LevelsScreen(NuclearGame nuclearGame) {


        super(nuclearGame);
        infoScreen12 = new InfoScreen12(nuclearGame, TextInfoScreenOne, "menuscreen-bg");
        gameScreen = new GameScreen(nuclearGame);
        nuke = new NuclearGame();
        ui = new LevelsScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

        ui.exit.addListener(exitButtonClickedListener);
        ui.level1.addListener(levelOneButtonClickedListener);
        ui.level2.addListener(levelTwoButtonClickedListener);
        ui.level3.addListener(levelThreeButtonClickedListener);
        ui.level4.addListener(levelFourButtonClickedListener);
    }

    @Override
    public void show() {
        super.show();
        updateLevelsButton();

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
            nuclearGame.gameScreen.setCurrentLevel(1);
            nuclearGame.setScreen(nuclearGame.infoScreen);
        }
    };
    ClickListener levelTwoButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            if (MemoryManager.loadPassedLevel() >= 1) {
                nuclearGame.gameScreen.setCurrentLevel(2);
                nuclearGame.setScreen(nuclearGame.infoScreen);
                // nuke.comp2 = true;
            }
        }
    };
    ClickListener levelThreeButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            if (MemoryManager.loadPassedLevel() >= 2) {
                nuclearGame.gameScreen.setCurrentLevel(3);
                nuclearGame.setScreen(nuclearGame.infoScreen);
                // nuke.comp3 = true;
            }
        }
    };
    ClickListener levelFourButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            System.out.println("here");
            if (MemoryManager.loadPassedLevel() >= 3) {
                nuclearGame.gameScreen.setCurrentLevel(4);
                nuclearGame.setScreen(nuclearGame.infoScreen);
                // nuke.comp4 = true;
            }
        }
    };

    private void updateLevelsButton() {
        int passedLevel = MemoryManager.loadPassedLevel();
        System.out.println("passed level: "  + passedLevel );
        switch (passedLevel) {
            case 4:
            case 3:
                ui.updateNpp4(true);
            case 2:
                ui.updateNpp3(true);
            case 1:
                ui.updateNpp2(true);
        }
    }
}
