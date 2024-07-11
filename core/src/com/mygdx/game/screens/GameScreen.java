package com.mygdx.game.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.ui.GameScreenUi;

public class GameScreen extends BaseScreen{

    public static int currentLevel;
    GameScreenUi ui;
    public GameScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new GameScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);
        stage.addListener(gameStopClickedListener);

    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    private void endGame() {
        int maxLevel = MemoryManager.loadPassedLevel();
        if (maxLevel < currentLevel) {
            MemoryManager. savePassedLevel(currentLevel);
        }
    }

    ClickListener gameStopClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            System.out.println("+++++++++++++++++++");
        nuclearGame.setScreen(LevelsScreen.infoScreen12);
        endGame();
        }
    };
}
