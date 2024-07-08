package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.ui.components.Potentiometer;
import com.mygdx.game.ui.components.TripleSwitch;

public class GameScreenUi extends UiComponent{
    public GameScreenUi(Skin skin) {
        Image image = new Image(new Texture("Group 317.png"));
        TripleSwitch tripleSwitch = new TripleSwitch(skin);
        root.setBackground(image.getDrawable());
        root.addActor(tripleSwitch);
    }
}
