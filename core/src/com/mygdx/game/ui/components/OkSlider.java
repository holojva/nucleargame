package com.mygdx.game.ui.components;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

public class OkSlider extends Slider {
    private float currentValue;
    private final float min;
    private final float max;
    public OkSlider(float min, float max, float stepSize, boolean vertical, Skin skin, float currentValue) {
        super(min, max, stepSize, vertical, skin);
        this.currentValue = min;
        this.min = min;
        this.max = max;
    }
    public void setCurrentValue(float currentValue) {
        this.currentValue = Math.max(min, Math.min(max, currentValue));
    }
    public float getCurrentValue() {
        return currentValue;
    }
}
