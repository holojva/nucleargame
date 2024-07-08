package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameScreenUi extends UiComponent{
    public GameScreenUi() {
        Image image = new Image(new Texture("Group 317.png"));
        root.setBackground(image.getDrawable());
    }
}
