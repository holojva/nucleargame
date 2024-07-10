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

    public Table table;

    public MenuScreenUi(Skin skin) {

        Image image = new Image(skin, "menuscreen-bg");
        table = new Table();
        Image image1 = new Image(new Texture("skins/default/raw/selection.png"));


        root.setBackground(image.getDrawable());
        root.addActor(table);
        table.setPosition(1300, 100);
        table.setSize(680, 940);
        table.setBackground(image1.getDrawable());

        startButton = new TextButton("start", skin);
        settingsButton = new TextButton("settings", skin);
        exitButton = new TextButton("exit", skin);

        table.add(startButton).width(400).height(90).pad(10).space(40);
        table.row();
        table.add(settingsButton).width(400).height(90).pad(10).space(40);
        table.row();
        table.add(exitButton).width(400).height(90).pad(10).space(40);


    }
}
