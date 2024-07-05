package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;

public class MenuScreenUi extends UiComponent {

    public Button startButton;
    public Button settingsButton;
    public Button exitButton;

    public Table table;

    public MenuScreenUi(Skin skin) {

        Label title = new Label("NCC SIMULATOR", skin);
        Image image = new Image(new Texture("skins/default/raw/white.png"));
        table = new Table();

        title.setAlignment(Align.right);
        title.setFontScale(2.5f);
        title.setColor(Color.BLACK);

        root.setBackground(image.getDrawable());
        table.setPosition(1100, 400);
        table.setSize(600, 600);

        startButton = new TextButton("start", skin);
        settingsButton = new TextButton("settings", skin);
        exitButton = new TextButton("exit", skin);




    }
}
