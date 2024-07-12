package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

public class PauseScreenUi extends UiComponent{
    public Button ret;
    public Label retLabel;
    public Button exit;
    public Label exitLabel;
    public PauseScreenUi(Skin skin) {
        Image image = new Image(new Texture("nuke13.1/nuke13.1/pausescreen.jpeg"));
        retLabel = new Label("return", skin, "molot-font", Color.BLACK);
        exitLabel = new Label("exit", skin, "molot-font", Color.BLACK);
        exit = new Button(skin, "whitebutton");
        ret = new Button(skin, "whitebutton");
        root.setBackground(image.getDrawable());
        root.addActor(ret);
        ret.setPosition(1000, 450);
        ret.setSize(200, 90);
        root.addActor(exit);
        exit.setPosition(600, 450);
        exit.setSize(200, 90);
        exit.addActor(exitLabel);
        exitLabel.setAlignment(Align.center);
        exitLabel.setPosition(70, 20);
        ret.addActor(retLabel);
        retLabel.setAlignment(Align.center);
        retLabel.setPosition(40, 20);
    }
}
