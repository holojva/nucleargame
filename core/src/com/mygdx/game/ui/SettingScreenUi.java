package com.mygdx.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;


public class SettingScreenUi extends UiComponent {

    public Button music;
    public Button sound;
    public Button exit;

    public Label musicLabel;
    public Label soundLabel;
    public Label exitLabel;
    public ImageButton music1;
    public ImageButton sound1;

    public SettingScreenUi(Skin skin) {

        Image background = new Image(skin,"settingsscreen-bg");
        music1 = new ImageButton(
                new Image(skin, "Screenshot_63").getDrawable(),
                new Image(skin, "Screenshot_63").getDrawable(),
                new Image(skin, "Screenshot_62").getDrawable()
        );
        //Image sound1 = new Image(skin, "Screenshot_63");
        sound1 = new ImageButton(
                new Image(skin, "Screenshot_63").getDrawable(),
                new Image(skin, "Screenshot_63").getDrawable(),
                new Image(skin, "Screenshot_62").getDrawable()
        );
        Table table = new Table();
        //Image image1 = new Image(new Texture("skins/default/raw/selection.png"));

       // table.setBackground(image1.getDrawable());
        table.setPosition(80, 100);
        table.setSize(400, 800);

        music = new Button(skin, "whitebutton");
        sound = new Button(skin,"whitebutton" );

        exit = new Button (skin, "whitebutton");

        musicLabel = new Label("music: ", skin);
        soundLabel = new Label("sound: ", skin);
        exitLabel = new Label("Return", skin);

        soundLabel.setAlignment(Align.left);
        root.setBackground(background.getDrawable());
        root.addActor(table);
        table.addActor(music);
        music.setPosition(57, 484);
        music.setSize(360, 80);
        music.addActor(musicLabel);
        musicLabel.setAlignment(Align.left);
        musicLabel.setPosition(20, 24);
        table.addActor(sound);
        sound.setPosition(57, 284);
        sound.setSize(360, 80);
        sound.addActor(soundLabel);
        soundLabel.setAlignment(Align.left);
        soundLabel.setPosition(20, 24);
        music.addActor(music1);
        music1.setPosition(255, 5);
        music1.setSize(90, 70);
        sound.addActor(sound1);
        sound1.setPosition(255, 5);
        sound1.setSize(90, 70);
        table.addActor(exit);
        exit.setPosition(44, 120);
        exit.setSize(385, 60);
        exit.add(exitLabel);
    }
    public void updateSwitchMus (boolean comp1){
        this.sound1.setChecked(comp1);
    }
    public void updateSwitchSound (boolean comp){
        this.music1.setChecked(comp);
    }
}
