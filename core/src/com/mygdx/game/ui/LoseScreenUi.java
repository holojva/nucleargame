package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.GameSettings;

public class LoseScreenUi extends UiComponent {
    public Label info;

    public LoseScreenUi(Skin skin) {
        Image background = new Image(new Texture("skins/default/raw/white.png"));

        info = new Label(GameSettings.TextInfoScreenOne, skin);

        root.setBackground(background.getDrawable());
    }
}
