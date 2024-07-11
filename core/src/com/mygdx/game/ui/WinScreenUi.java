package com.mygdx.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.*;

public class WinScreenUi extends UiComponent {
    public Label info;

    public WinScreenUi(Skin skin) {
        Image background = new Image(skin, "infoscreen-bg");
        root.setBackground(background.getDrawable());
        info = new Label("", skin);
        root.addActor(info);
    }
}
