package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.ui.components.*;

public class GameScreenUi extends UiComponent{

    public Potentiometer speedControl;
    public TripleSwitch battery;
    public Slider kernels;
    public Switch SPOT;
    public Image blackout;
    public PowerDisplay closeToFail;
    public PowerDisplay generatedPower;
    public PowerDisplay batteryCharge;
    public PowerDisplay fatigue;
    public Button cheerUp;
    public Button pause;
    public Button info;
    public Button tutorial;
    public Label pauseLabel;
    public Label infoLabel;
    public Label tutorialLabel;
    public EnergyChart energyChart;
    public Image kernelses;
    public Scheme scheme;


    public GameScreenUi(Skin skin) {

        Image image = new Image(skin, "gamescreen-bg");
        blackout = new Image(skin,  "blackout");
        battery = new TripleSwitch(skin);
        kernels = new Slider(0, 1, 0.01f, false, skin);
        SPOT = new Switch(skin);
        speedControl = new Potentiometer(skin);
        closeToFail = new PowerDisplay(0, 1, 0.8f, 0.04f);
        generatedPower = new PowerDisplay(0, 1, 0.8f, 0.04f);
        batteryCharge = new PowerDisplay(0, 1, 0.8f, 0.04f);
        fatigue = new PowerDisplay(0, 1, 0.8f, 0.04f);
        energyChart = new EnergyChart(skin);
        pauseLabel = new Label("Pause", skin, "molot-font", Color.BLACK);
        tutorialLabel = new Label("Tutorial", skin, "molot-font", Color.BLACK);
        infoLabel = new Label("Info", skin, "molot-font", Color.BLACK);
        cheerUp = new Button(skin, "biggraybutton");
        pause = new Button(skin, "graybutton");
        tutorial = new Button(skin, "graybutton");
        info = new Button(skin, "graybutton");
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
        batteryCharge.setPosition(619, 292);
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
        root.addActor(info);
        info.setPosition(1230, 950);
        info.setSize(200, 90);
        root.addActor(tutorial);
        tutorial.addActor(tutorialLabel);
        pause.addActor(pauseLabel);
        info.addActor(infoLabel);
        infoLabel.setAlignment(Align.center);
        tutorialLabel.setAlignment(Align.center);
        pauseLabel.setAlignment(Align.center);
        pauseLabel.setPosition(70, 35);
        tutorialLabel.setPosition(55, 35);
        infoLabel.setPosition(80, 35);
        tutorial.setPosition(1450, 950);
        tutorial.setSize(200, 90);
        root.addActor(pause);
        pause.setPosition(1670, 950);
        pause.setSize(200, 90);
        root.addActor(energyChart);
        energyChart.setSize(700, 490);
        energyChart.setPosition(879, 520);
        root.addActor(kernelses);
        kernelses.setPosition(75, 620);
        kernelses.setSize(54, 270);

    }


}
