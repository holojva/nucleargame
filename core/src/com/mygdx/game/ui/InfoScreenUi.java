package com.mygdx.game.ui;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class InfoScreenUi extends UiComponent {

    public Label info;

    public Image image;

    public InfoScreenUi(Skin skin) {

        Image background = new Image(new Texture(""));

        info = new Label("text", skin);
        image = new Image(new Texture("texture"));

        root.add(info);
        info.setPosition(270, 270);
        info.setSize(600, 760);
        root.add(image);
        image.setPosition(600, 270);
    }
}
