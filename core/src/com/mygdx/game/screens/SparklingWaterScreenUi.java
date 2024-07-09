package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ui.UiComponent;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.util.Random;

public class SparklingWaterScreenUi extends UiComponent {
    Image glass;
    Image rizqa;
    Image water;
    Table table;

    public SparklingWaterScreenUi(Skin skin) {
        glass = new Image(new Texture(""));
        //rizqa = new Image(new Texture());
       // water = new Image(new Texture());
        Image background = new Image(new Texture("skins/default/raw/white.png"));
        table = new Table();
        Random r = new Random();

        root.setBackground(background.getDrawable());
        root.addActor(water);
        //water.setPosition();
        //water.setSize();
        root.addActor(table);
        //table.setPosition();
        //table.setSize();
        table.add(glass);
        table.addActor(rizqa);
       // rizqa.setSize();
        rizqa.setPosition(glass.getImageX(), glass.getImageHeight() - r.nextInt(30));

    }
}
