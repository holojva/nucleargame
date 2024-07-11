package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.ui.components.*;

public class GameScreenUi extends UiComponent{

    public Potentiometer speedControl;
    public TripleSwitch battery;
    public Slider kernels;
    public Switch SPOT;
    public Image blackout;
    public PowerDisplay closeToFail;
    public Label closeToFailLabel;
    public PowerDisplay generatedPower;
    public Label generatedPowerLabel;
    public PowerDisplay batteryCharge;
    public Label batteryChargeLabel;
    public PowerDisplay fatigue;
    public Label fatigueLabel;
    public Label cheerUpLabel;
    public EnergyChart energyChart;
    public Image kernelses;
    public Scheme scheme;
    public Button cheerUp;
    public Label date;
    public Label time;
    public Image batteryImage;


    public GameScreenUi(Skin skin) {

        Image image = new Image(skin, "gamescreen-bg");
        blackout = new Image(skin,  "blackout");
        battery = new TripleSwitch(skin);
        batteryImage = new Image(skin, "battery");
        kernels = new Slider(0, 1, 0.01f, false, skin);
        SPOT = new Switch(skin);
        cheerUp = new Button(skin, "graybutton");
        date = new Label( "Date: 18 October. (3 jobtime)", skin, "molot-font", Color.WHITE);
        time = new Label("TIME: 12:17", skin, "molot-font", Color.WHITE);
        speedControl = new Potentiometer(skin);
        closeToFail = new PowerDisplay(0, 1, 0.8f, 0.04f);
        generatedPower = new PowerDisplay(0, 1, 0.8f, 0.04f);
        batteryCharge = new PowerDisplay(0, 1, 0.8f, 0.04f);
        fatigue = new PowerDisplay(0, 1, 0.8f, 0.04f);
        closeToFailLabel = new Label("Close to Fail", skin, "molot-font", Color.BLACK);
        generatedPowerLabel = new Label("Generated Power",  skin, "molot-font", Color.BLACK);
        batteryChargeLabel = new Label("Battery charge",  skin, "molot-font", Color.BLACK);
        fatigueLabel = new Label("Fatigue",  skin, "molot-font", Color.BLACK);
        energyChart = new EnergyChart(skin);
        cheerUpLabel = new Label("Cheer Up", skin, "molot-font", Color.BLACK);
        kernelses = new Image(skin, "kernels");
        scheme = new Scheme(skin);

        root.setBackground(image.getDrawable());
        root.addActor(scheme);
        scheme.setPosition(42, 520);
        scheme.setSize(810, 480);
        root.addActor(battery);
        root.addActor(kernels);
        kernels.setPosition(1250, 30);
        kernels.setSize(550, 150);
        root.addActor(SPOT);
        root.addActor(closeToFail);
        closeToFail.setPosition(619, 402);
        closeToFail.setCurrentValue(0);
        root.addActor(generatedPower);
        generatedPower.setPosition(618, 345);
        generatedPower.setCurrentValue(0.7f);
        root.addActor(batteryCharge);
        batteryCharge.setPosition(619, 286);
        batteryCharge.setCurrentValue(0);
        root.addActor(fatigue);
        fatigue.setPosition(618, 228);
        fatigue.setCurrentValue(0);
        root.addActor(speedControl);
        speedControl.setPosition(935, 20);
        speedControl.setSize(180, 180);
        root.addActor(cheerUp);
        cheerUp.setPosition(1230, 310);
        cheerUp.setSize(670, 90);
        cheerUp.add(cheerUpLabel);
        root.addActor(energyChart);
        energyChart.setSize(700, 490);
        energyChart.setPosition(879, 520);
        root.addActor(kernelses);
        kernelses.setPosition(75, 620);
        kernelses.setSize(54, 270);
        root.addActor(closeToFailLabel);
        closeToFailLabel.setPosition(1242, 860);
        root.addActor(generatedPowerLabel);
        generatedPowerLabel.setPosition(1242, 745);
        root.addActor(batteryChargeLabel);
        batteryChargeLabel.setPosition(1242, 630);
        root.addActor(fatigueLabel);
        fatigueLabel.setPosition(1242, 512);
        root.addActor(date);
        date.setPosition(27, 400);
        root.addActor(time);
        time.setPosition(27, 350);
        root.addActor(batteryImage);
        batteryImage.setPosition(600, 300);
    }


}