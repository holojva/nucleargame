package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;


public class SettingScreenUi extends UiComponent  {

    public Button music;
    public Button sound;
    public Button exit;

    public Label musicLabel;
    public Label soundLabel;

    public SettingScreenUi(Skin skin) {

        Label titlelabel = new Label("Settings", skin);
        titlelabel.setFontScale(2.5f);
        Image background = new Image(new Texture(""));
        Table table = new Table();

        music = new Button(skin);
        sound = new Button(skin);
        exit = new TextButton("return", skin);

        musicLabel = new Label("music: ", skin);
        soundLabel = new Label("sound: ", skin);

        musicLabel.setAlignment(Align.left);
        soundLabel.setAlignment(Align.left);

        root.setBackground(background.getDrawable());
        root.add(table);
        table.add(music).width(500);
        music.add(musicLabel).width(300);
        table.row();
        table.add(sound).width(500);
        sound.add(soundLabel).width(300);
        table.row();
        table.add(exit);

    }
}
