package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AudioManager;
import com.mygdx.game.GameSettings;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.ui.GameScreenUi;
import com.mygdx.game.ui.components.ChartValues;
import com.mygdx.game.ui.components.Switch;

import java.util.ArrayList;
import java.util.Arrays;

public class GameScreen extends BaseScreen{

    public static int currentLevel;
    GameScreenUi ui;
    long startTime;
    float profit;
    boolean loos;
    boolean win;
    float sleepTime;
    float accumulator;
    ArrayList<ChartValues> listOfValues;

    @Override
    public void show() {
        super.show();
        startTime = TimeUtils.millis();
        ui.generatedPower.setCurrentValue(0.5f);
    }

    public GameScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new GameScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);
        profit = 0;
        loos = false;
        win = false;
        sleepTime = 3f;
        accumulator = 0;
        listOfValues = new ArrayList<>(Arrays.asList(new ChartValues(3, 10),
                new ChartValues(5, 12),
                new ChartValues(2, 13),
                new ChartValues(5, 9),
                new ChartValues(1, 10),
                new ChartValues(10, 12),
                new ChartValues(5, 12),
                new ChartValues(5, 5))
        );

        ui.SPOT.addListener(spotClickedListener);
        ui.battery.addListener(batteryClickedListener);
        ui.speedControl.addListener(speedControlClickedListener);
        ui.kernels.addListener(kernelsClickedListener);
        ui.cheerUp.addListener(cheerUpStopClickedListener);
        ui.pause.addListener(pauseStopClickedListener);
        ui.tutorial.addListener(tutorialStopClickedListener);
        ui.info.addListener(infoStopClickedListener);
        ui.energyChart.setValuesList(listOfValues, true);

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

    ClickListener infoStopClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(LevelsScreen.infoScreen);
        endGame();
        }
    };
    ClickListener tutorialStopClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            //nuclearGame.setScreen(nuclearGame.);
            endGame();
        }
    };
    ClickListener pauseStopClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            //nuclearGame.setScreen(LevelsScreen.pauseScreen);
            endGame();
        }
    };

    ClickListener cheerUpStopClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.sparklingWaterScreen);
            AudioManager.playMusic(AudioManager.coffeeScreenBackgroundMusic);
        }
    };


    ClickListener spotClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            passiveFatigue();
        }

    };

    ClickListener batteryClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            passiveFatigue();
        }

    };

    ClickListener speedControlClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            passiveFatigue();
        }

    };

    ClickListener kernelsClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            passiveFatigue();
        }
    };

    @Override
    public void render(float delta) {
        super.render(delta);
        float x = ui.kernels.getValue();
        float y = (float) ui.speedControl.getValue();
        float t = (float) ((Math.pow(x * 100, 0.7) + 2.5 * Math.sin(x * 30)) / 100);
        float z = (float) (Math.pow(x, 0.3) * 1 / Math.pow((y - t), 0.1));

        ui.generatedPower.setCurrentValue(z);

        long currentTime = TimeUtils.millis() - startTime;

        if (currentTime >= ChartValues.getSumTime(listOfValues) * 1_000L) startTime = TimeUtils.millis();
        else ui.energyChart.currentPosition = (int) (currentTime / 1000);


        if (ui.SPOT.currentState == 1) {
            ui.closeToFail.decreaseValue(0.006f);
            ui.generatedPower.decreaseValue(0.006f);
        }
        if (ui.battery.currentState == 0 && ui.batteryCharge.getCurrentValue() != 1) {
            ui.generatedPower.decreaseValue(0.006f);
            ui.batteryCharge.increaseValue(0.006f);
        }
        if (ui.battery.currentState == 1) {
            ui.generatedPower.increaseValue(profit);
            profit = 0;
        }

        if (ui.battery.currentState == 2 && ui.batteryCharge.getCurrentValue() != 0) {
            float startCharge = ui.batteryCharge.getCurrentValue();
            ui.generatedPower.increaseValue(0.006f);
            ui.batteryCharge.decreaseValue(0.006f);
            profit = ui.batteryCharge.getCurrentValue() - startCharge;
        }

        ui.generatedPower.increaseValue(0.006f);

        if (ui.generatedPower.getCurrentValue() < (ui.generatedPower.getIdealValue() - ui.generatedPower.getInaccuracy())
                || ui.generatedPower.getCurrentValue() > (ui.generatedPower.getIdealValue() + ui.generatedPower.getInaccuracy())) {
            ui.closeToFail.increaseValue(0.00006f);
        }

        if (ui.closeToFail.getCurrentValue() == 1) loos = true;

        if (TimeUtils.millis() - startTime == 24000L && !loos) {
            nuclearGame.setScreen(nuclearGame.winScreen);
            win = true;
        }
        if (loos) {
            nuclearGame.setScreen(nuclearGame.loseScreen);
        }

        if (ui.fatigue.getCurrentValue() < 0.7) {
            ui.cheerUp.getColor().a = 0;
        }
        else ui.cheerUp.getColor().a = 1;


        if (ui.kernels.getValue() < 0.3) ui.kernelses.setPosition(75, 653);
        if (ui.kernels.getValue() >= 0.3) ui.kernelses.setPosition(75, 670);
        if (ui.kernels.getValue() >= 0.5) ui.kernelses.setPosition(75, 700);
        if (ui.kernels.getValue() >= 0.7) ui.kernelses.setPosition(75, 730);
        if (ui.kernels.getValue() >= 0.9) ui.kernelses.setPosition(75, 760);

        if (ui.speedControl.getValue() < 0.3) GameSettings.schemeCoolDown = 0.3f;
        if (ui.speedControl.getValue() >= 0.3) GameSettings.schemeCoolDown = 0.24f;
        if (ui.speedControl.getValue() >= 0.5) GameSettings.schemeCoolDown = 0.19f;
        if (ui.speedControl.getValue() >= 0.7) GameSettings.schemeCoolDown = 0.14f;
        if (ui.speedControl.getValue() >= 0.9) GameSettings.schemeCoolDown = 0.1f;

        if (ui.fatigue.getCurrentValue() >= 0.7) {
            sleeping(delta);
        }


    }

    private void passiveFatigue() {
        long fatigueStartTime = 300L;
        if (TimeUtils.millis() - startTime >= fatigueStartTime) {
            ui.fatigue.increaseValue(0.06f);
        }
    }

    private void sleeping(float delta) {
        accumulator += delta;
        if (accumulator < sleepTime) stage.addActor(ui.blackout);
        else accumulator -= sleepTime;
    }
}




