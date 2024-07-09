package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.mygdx.game.ui.components.Potentiometer;
import com.mygdx.game.ui.components.PowerDisplay;
import com.mygdx.game.ui.components.Switch;
import com.mygdx.game.ui.components.TripleSwitch;

public class GameScreenUi extends UiComponent{
    public GameScreenUi(Skin skin) {
        Image image = new Image(new Texture("Group 317.png"));
        TripleSwitch tripleSwitch = new TripleSwitch(skin);
        Slider slider = new Slider(0, 100, 10, false, skin);
        Switch switch1 = new Switch(skin);
        PowerDisplay powerDisplay = new PowerDisplay(0, 100, 80, 4);
        root.setBackground(image.getDrawable());
        root.addActor(tripleSwitch);
        root.addActor(slider);
        slider.setPosition(1250, 30);
        slider.setSize(480, 150);
        root.addActor(switch1);
        root.addActor(powerDisplay);
        powerDisplay.setPosition(617, 345);
        powerDisplay.setCurrentValue(50);
    }
}
