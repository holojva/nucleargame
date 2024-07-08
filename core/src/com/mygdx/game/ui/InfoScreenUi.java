package com.mygdx.game.ui;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.GameSettings;

public class InfoScreenUi extends UiComponent {

    public Label info;

    public Image station;

    public InfoScreenUi(Skin skin) {

        Image background = new Image(new Texture("skins/default/raw/white.png"));

        station = new Image(new Texture("skins/default/raw/selection.png"));

        info = new Label(GameSettings.TextInfoScreenOne, skin);

        root.setBackground(background.getDrawable());
        root.addActor(info);
        info.setPosition(30, 200);
        info.setColor(Color.BLACK);
        info.setFontScale(2f);
        info.setSize(600, 1000);
        root.addActor(station);
        station.setPosition(970, 190);
        station.setSize(920, 800);
    }
}
