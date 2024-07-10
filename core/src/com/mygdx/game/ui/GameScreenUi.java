package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.mygdx.game.ui.components.*;

public class GameScreenUi extends UiComponent{
    public Potentiometer speedControl;
    public TripleSwitch battery;
    public Slider kernels;
    public Switch SPOT;
    public PowerDisplay closeToFail;
    public PowerDisplay generatedPower;
    public PowerDisplay batteryCharge;
    public PowerDisplay fatigue;
    public GameScreenUi(Skin skin) {
        Image image = new Image(new Texture("Group 317.png"));
        battery = new TripleSwitch(skin);
        kernels = new Slider(0, 1, 0.01f, false, skin);
        SPOT = new Switch(skin);
        speedControl = new Potentiometer(skin);
        closeToFail = new PowerDisplay(0, 100, 80, 4);
        generatedPower = new PowerDisplay(0, 100, 80, 4);
        batteryCharge = new PowerDisplay(0, 100, 80, 4);
        fatigue = new PowerDisplay(0, 100, 80, 4);
        root.setBackground(image.getDrawable());
        root.addActor(battery);
        root.addActor(kernels);
        kernels.setPosition(1250, 30);
        kernels.setSize(550, 150);
        root.addActor(SPOT);
        root.addActor(closeToFail);
        closeToFail.setPosition(619, 402);
        closeToFail.setCurrentValue(30);
        root.addActor(generatedPower);
        generatedPower.setPosition(618, 345);
        generatedPower.setCurrentValue(30);
        root.addActor(batteryCharge);
        batteryCharge.setPosition(619, 292);
        batteryCharge.setCurrentValue(0);
        root.addActor(fatigue);
        fatigue.setPosition(618, 228);
        fatigue.setCurrentValue(30);
        root.addActor(speedControl);
        speedControl.setPosition(600, 30);
        speedControl.setSize(300, 300);
    }

}
