package com.mygdx.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class MenuScreenUi extends UiComponent {
    public Button startButton;
    public Button settingsButton;
    public Button exitButton;

    /*public MenuUI(Skin skin) {

        Label title = new Label("симулятор оператора АЭС", skin);
        Image image = new Image(new Texture("textures/background.png"));

        title.setAlignment(Align.center);
        title.setFontScale(2.5f);
        startButton = new TextButton("start", skin);
        settingsButton = new TextButton("settings", skin);
        exitButton = new TextButton("exit", skin);

        root.setBackground(image.getDrawable());
        root.columnDefaults(1);
        root.add(title).width(400).height(150);
        root.row();
        root.add(startButton).width(400).height(60).space(100);
        root.row();
        root.add(settingsButton).width(400).height(60).space(100);
        root.row();
        root.add(exitButton).width(400).height(60).space(100);
    }*/
}
