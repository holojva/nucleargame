package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
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

        Table table = new Table();
        Label title = new Label("Choose NPP", skin);
        Image image = new Image(new Texture("nuke/nuke/nuclear3.png"));
        Image level11 = new Image(new Texture("nuke/nuke/nuclear7.png"));
        Image level22 = new Image(new Texture("nuke/nuke/nuclear7.png"));
        Image level33 = new Image(new Texture("nuke/nuke/nuclear7.png"));
        Image level44 = new Image(new Texture("nuke/nuke/nuclear7.png"));
        level1 = new Button(level11.getDrawable());
        level2 = new Button(image.getDrawable());
        level3 = new Button(image.getDrawable());
        level4 = new Button(image.getDrawable());
        exit = new TextButton("Return", skin);
        root.setBackground(image.getDrawable());

        root.addActor(title);
        title.setAlignment(Align.center);
        title.setFontScale(2.5f);
        title.setColor(Color.BLACK);
        title.setPosition(420, 900);
        title.setSize(1000, 100);

        root.addActor(table);
        table.setPosition(79, 370);
        table.setSize(1780, 420);

        table.addActor(level1);
        level1.setPosition(30, 18);
        level1.setSize(390, 390);
        table.addActor(level2);
        level2.setPosition(470, 18);
        level2.setSize(390, 390);
        table.addActor(level3);
        level3.setPosition(910, 18);
        level3.setSize(390, 390);
        table.addActor(level4);
        level4.setPosition(1360, 18);
        level4.setSize(390, 390);

        root.addActor(exit);
        exit.setPosition(820, 120);
        exit.setSize(200, 100);
    }
}
