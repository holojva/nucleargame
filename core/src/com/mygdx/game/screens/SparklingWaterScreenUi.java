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
        glass = new Image(skin, "glass");
        rizqa = new Image(skin, "tab");
        water = new Image(skin, "tarkhun");
        Image background = new Image(skin, "coffeescreen-bg");
        table = new Table();
        Random r = new Random();

        root.setBackground(background.getDrawable());
        root.addActor(water);
        water.setPosition(1280, 340);
        root.addActor(table);
        table.setPosition(1093, 204);
        table.setSize(600, 600);
        table.add(glass);
        glass.setPosition(1140,374);
        glass.setSize(400, 200);
        table.addActor(rizqa);
        rizqa.setPosition(234, 470 - r.nextInt(30));
        rizqa.setSize(180, 12);

    }
}
