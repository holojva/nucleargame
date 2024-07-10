package com.mygdx.game.ui;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.GameSettings;

public class InfoScreenUi1 extends UiComponent {

    public Label info;

    public Image station;

    public InfoScreenUi1(Skin skin, String station1, String text) {

        Image background = new Image(skin, "infoscreen-bg");
        station = new Image(skin, station1);
        info = new Label(text, skin);
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
