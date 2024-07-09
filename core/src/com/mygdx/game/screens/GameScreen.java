package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.GameScreenUi;
import com.mygdx.game.ui.components.Switch;

public class GameScreen extends BaseScreen {
    GameScreenUi ui;
    long startTime;

    @Override
    public void show() {
        super.show();
        startTime = TimeUtils.millis();
    }

    public GameScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new GameScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

        ui.SPOT.addListener(spotClickedListener);
        //ui.battery.addListener();
        //ui.speedControl.addListener();
        //ui.kernels.addListener();
    }

    long fatigueStartTime = 30000L;

    ClickListener spotClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            if (TimeUtils.millis() - startTime >= fatigueStartTime) {
                ui.fatigue.increase(0.3f);
            }
            while (ui.SPOT.currentState == 1){
                ui.closeToFail.decrease(5f);
                ui.generatedPower.decrease(5f);
            }

        }

    };
}



