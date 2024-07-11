package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.GameScreenUi;
import com.mygdx.game.ui.components.Switch;

public class GameScreen extends BaseScreen{
    GameScreenUi ui;
    long startTime;
    float profit;

    @Override
    public void show() {
        super.show();
        startTime = TimeUtils.millis();
    }

    public GameScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new GameScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);
        stage.addListener(gameStopClickedListener);
        profit = 0;


        ui.SPOT.addListener(spotClickedListener);
        ui.battery.addListener(batteryClickedListener);
        ui.speedControl.addListener(speedControlClickedListener);
        ui.kernels.addListener(kernelsClickedListener);
        ui.cheerUp.addListener(cheerUpStopClickedListener);
    }
    ClickListener gameStopClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            //nuclearGame.setScreen(nuclearGame.infoScreen12);
        }
    };

    ClickListener cheerUpStopClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.sparklingWaterScreen);
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
        float z = (float) (Math.pow(x, 0.3) * 1 / Math.pow((y - 0.02), 0.1));

        ui.generatedPower.setCurrentValue(z);





        if (ui.SPOT.currentState == 1) {
            ui.closeToFail.decreaseValue(0.06f);
            ui.generatedPower.decreaseValue(0.06f);
        }
        if (ui.battery.currentState == 0 && ui.batteryCharge.getCurrentValue() != 1) {
            ui.generatedPower.decreaseValue(0.004f);
            ui.batteryCharge.increaseValue(0.004f);
        }
        if (ui.battery.currentState == 1) {
            ui.generatedPower.increaseValue(profit);
            profit = 0;
        }

        if (ui.battery.currentState == 2 && ui.batteryCharge.getCurrentValue() != 0) {
            float startCharge = ui.batteryCharge.getCurrentValue();
            ui.generatedPower.increaseValue(0.007f);
            ui.batteryCharge.decreaseValue(0.004f);
            profit = ui.batteryCharge.getCurrentValue() - startCharge;
        }

        ui.generatedPower.increaseValue(0.68f);

        if (ui.generatedPower.getCurrentValue() < (ui.generatedPower.getIdealValue() - ui.generatedPower.getInaccuracy())
                || ui.generatedPower.getCurrentValue() > (ui.generatedPower.getIdealValue() + ui.generatedPower.getInaccuracy()))
        {
            ui.closeToFail.increaseValue(0.005f);
        }

    }

    private void passiveFatigue(){
        long fatigueStartTime = 60000L;
        if (TimeUtils.millis() - startTime >= fatigueStartTime) {
            ui.fatigue.increaseValue(0.007f);
        }
    }
}



