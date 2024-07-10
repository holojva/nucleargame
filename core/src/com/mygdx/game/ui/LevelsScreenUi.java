package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class LevelsScreenUi extends UiComponent {
    public Button level1;
    public ImageButton level2;
    public ImageButton level3;
    public ImageButton level4;
    public Button exit;
    ImageButton level;

    public LevelsScreenUi(Skin skin) {
        Table table = new Table();
        Label title = new Label("Choose NPP", skin);
        Image image = new Image(skin,"levelscreen-bg");
        Image level11 = new Image(skin,"obninsk-level-color");
        level1 = new Button(level11.getDrawable());
        level3 = new ImageButton(
                new Image(skin, "beloyarsk-level-bw").getDrawable(),
                new Image(skin, "beloyarsk-level-bw").getDrawable(),
                new Image(skin, "beloyarsk-level-color").getDrawable()
                );
        // level = new ImageButton((skin,complete2 ? "bilibino-level-bw" : "bilibino-level-color");
        level2 = new ImageButton(
                new Image(skin, "bilibino-level-color").getDrawable(),
                new Image(skin, "bilibino-level-color").getDrawable(),
                new Image(skin, "bilibino-level-bw").getDrawable()
        );
        //level3 = new Button(level33.getDrawable());
        level4 = new ImageButton(
                new Image(skin, "chernobyl-level-bw").getDrawable(),
                new Image(skin, "chernobyl-level-bw").getDrawable(),
                new Image(skin, "chernobyl-level-color").getDrawable()

        );
        //level4 = new Button(level44.getDrawable());
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
    public void updateNpp2 (boolean comp){
        level2.setChecked(comp);
    }
}
