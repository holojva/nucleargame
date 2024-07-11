package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.GameSettings.SCREEN_HEIGHT;
import static com.mygdx.game.GameSettings.SCREEN_WIDTH;

public class MenuScreenUi extends UiComponent {

    public Button startButton;
    public Button settingsButton;
    public Button exitButton;

    public Label start;
    public Label settings;
    public Label exit;


    public Table table;

    public MenuScreenUi(Skin skin) {

        Image image = new Image(skin, "menuscreen-bg");
        table = new Table();


        root.setBackground(image.getDrawable());
        root.addActor(table);
        table.setPosition(1300, 30);
        table.setSize(680, 940);

        startButton = new Button( skin, "whitebutton");
        settingsButton = new Button (skin, "whitebutton");
        exitButton = new Button(skin, "whitebutton");
        start = new Label("Start", skin);
        settings = new Label("Settings", skin);
        exit = new Label("Exit", skin);

        table.add(startButton).width(400).height(90).pad(10).space(40);
        startButton.add(start);
        table.row();
        table.add(settingsButton).width(400).height(90).pad(10).space(40);
        settingsButton.add(settings);
        table.row();
        table.add(exitButton).width(400).height(90).pad(10).space(40);
        exitButton.add(exit);


    }
}
