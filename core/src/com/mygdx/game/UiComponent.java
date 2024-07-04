package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class UiComponent {
    public Table root;

    public UiComponent() {
        root = new Table();
        root.setFillParent(true);
    }

}
