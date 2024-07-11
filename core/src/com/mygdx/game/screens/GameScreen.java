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
import java.util.OptionalDouble;

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

    ArrayList <Float> xValues;
    ArrayList <Float> yValues;
    float lastTermperature = 0;

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

        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
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

        float readX = Math.max(0f, Math.min(1f, ui.kernels.getValue()));
        float readY = Math.max(0f, Math.min(1f, ui.speedControl.getValue()));

        if (xValues.size() < 50) xValues.add(readX);
        else {
            xValues.remove(0);
            xValues.add(readX);
        }

        if (yValues.size() < 50) yValues.add(readY);
        else {
            yValues.remove(0);
            yValues.add(readY);
        }

        double x = xValues.stream().mapToDouble(it -> (double) it).average().orElse(0);
        double y = yValues.stream().mapToDouble(it -> (double) it).average().orElse(0);
        // System.out.println("sin: " +  Math.sin(TimeUtils.millis() % 100000 / 1000f ));
        float z = (float) (Math.pow(x, 0.3) * 1 / Math.pow(Math.abs((y - lastTermperature)), 0.1)
                * (((8 - Math.sin(TimeUtils.millis() % 100000 / 1000f * 0.5)) / 9)));
        lastTermperature = (float) ((Math.pow(z * 100, 0.7) + 2.5 * Math.sin(TimeUtils.millis() / 1000f * 30)) / 100);

        // System.out.println("=====" + z);

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

        if (ui.battery.currentState == 1) {
            ui.batteryImage.getColor().a = 0;
        }
        if (ui.battery.currentState != 1) {
            ui.batteryImage.getColor().a = 1;
        }

        if (ui.closeToFail.getCurrentValue() == 1) loos = true;

        if (TimeUtils.millis() - startTime == 240000L && !loos) {
            nuclearGame.setScreen(nuclearGame.winScreen);
            win = true;
        }
        if (loos) {
            nuclearGame.setScreen(nuclearGame.loseScreen);
        }

        if (ui.fatigue.getCurrentValue() < 0.7) {
            ui.cheerUp.getColor().a = 0;
            ui.cheerUp.setDisabled(false);
        }
        else {
            ui.cheerUp.getColor().a = 1;
            ui.cheerUp.setDisabled(true);
        }


        if (x >= 0.9) ui.kernelses.setPosition(75, 760);
        else if (x >= 0.7) ui.kernelses.setPosition(75, 730);
        else if (x >= 0.5) ui.kernelses.setPosition(75, 700);
        else if (x >= 0.3) ui.kernelses.setPosition(75, 670);
        else if (x< 0.3) ui.kernelses.setPosition(75, 653);

        if (ui.speedControl.getValue() >= 0.9) GameSettings.schemeCoolDown = 0.1f;
        else if (ui.speedControl.getValue() >= 0.7) GameSettings.schemeCoolDown = 0.14f;
        else if (ui.speedControl.getValue() >= 0.5) GameSettings.schemeCoolDown = 0.19f;
        else if (ui.speedControl.getValue() >= 0.3) GameSettings.schemeCoolDown = 0.24f;
        else if (ui.speedControl.getValue() < 0.3) GameSettings.schemeCoolDown = 0.3f;

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
        if (accumulator < sleepTime) {
            stage.addActor(ui.blackout);
            ui.blackout.setSize(GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);
        }
        else accumulator -= sleepTime;
    }
}




