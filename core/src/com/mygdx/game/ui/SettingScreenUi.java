package com.mygdx.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;


public class SettingScreenUi extends UiComponent {

    public Button music;
    public Button sound;
    public Button exit;
    public Button musicSwitch;
    public Button soundSwitch;

    public Label musicLabel;
    public Label soundLabel;

    public SettingScreenUi(Skin skin) {

        Image background = new Image(new Texture("nuke/nuke/nuclear.png"));
        Table table = new Table();
        Image image1 = new Image(new Texture("nuke/nuke/nuclear.png"));

        table.setBackground(image1.getDrawable());
        table.setPosition(80, 100);
        table.setSize(400, 800);

        music = new Button(skin);
        sound = new Button(skin);
        musicSwitch = new Button(background.getDrawable());
        soundSwitch = new Button(background.getDrawable());

        exit = new TextButton("return", skin);

        musicLabel = new Label("music: ", skin);
        soundLabel = new Label("sound: ", skin);

        soundLabel.setAlignment(Align.left);

        root.setBackground(background.getDrawable());
        root.addActor(table);
        table.addActor(music);
        music.setPosition(27, 684);
        music.setSize(360, 80);
        music.addActor(musicLabel);
        musicLabel.setAlignment(Align.left);
        musicLabel.setPosition(2, 30);
        table.addActor(sound);
        sound.setPosition(27, 484);
        sound.setSize(360, 80);
        sound.addActor(soundLabel);
        soundLabel.setAlignment(Align.left);
        soundLabel.setPosition(2, 30);
        music.addActor(musicSwitch);
        musicSwitch.setPosition(255, 5);
        musicSwitch.setSize(90, 70);
        sound.addActor(soundSwitch);
        soundSwitch.setPosition(255, 5);
        soundSwitch.setSize(90, 70);
        table.addActor(exit);
        exit.setPosition(9, 120);
        exit.setSize(385, 60);
    }
}
