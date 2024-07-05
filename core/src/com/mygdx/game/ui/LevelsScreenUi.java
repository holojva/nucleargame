package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class LevelsScreenUi extends UiComponent {
    public Button level1;
    public Button level2;
    public Button level3;
    public Button level4;
    public Button exit;

    public LevelsScreenUi(Skin skin) {

        Label title = new Label("Choose NPP", skin);
        Image image = new Image(new Texture(""));

        title.setAlignment(Align.center);
        title.setFontScale(2.5f);

        level1 = new TextButton(" 1 ", skin);
        level2 = new TextButton(" 2 ", skin);
        level3 = new TextButton(" 3 ", skin);
        level4 = new TextButton(" 4 ", skin);
        exit = new TextButton("Return", skin);

        root.setBackground(image.getDrawable());
        root.add(title).width(700);
        root.row();
        root.add(level1);
        root.add(level1);
        root.add(level1);
        root.add(level1);
        root.row();
        root.add(exit);
    }
}
