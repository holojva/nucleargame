package com.mygdx.game;

import static com.mygdx.game.GameSettings.SCREEN_HEIGHT;
import static com.mygdx.game.GameSettings.SCREEN_WIDTH;
import static com.mygdx.game.GameSettings.SKIN_PATH;
import static com.mygdx.game.GameSettings.TextInfoScreenOne;
import static com.mygdx.game.GameSettings.TextInfoScreenOneFinal;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.screens.*;
import com.mygdx.game.screens.infoScreens.InfoScreen;
import com.mygdx.game.screens.infoScreens.InfoScreen12;
import com.mygdx.game.ui.WinScreenUi;

public class NuclearGame extends Game {
	public Skin skin;
	public OrthographicCamera camera;
	public FitViewport viewport;

	public MenuScreen menuScreen;
	public LevelsScreen levelsScreen;
	public SettingsScreen settingsScreen;
	public InfoScreen infoScreen;
	public GameScreen gameScreen;
	public InfoScreen12 infoScreen12;
	public WinScreen winScreen;
	public LoseScreen loseScreen;
	public boolean comp2=false;
	public boolean comp3=false;
	public boolean comp4=false;
	public SparklingWaterScreen sparklingWaterScreen;

	@Override
	public void create () {

		camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
		viewport = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camera);

		skin = new Skin(Gdx.files.internal(SKIN_PATH));
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

		menuScreen = new MenuScreen(this);
		levelsScreen = new LevelsScreen(this);
		settingsScreen = new SettingsScreen(this);
		infoScreen = new InfoScreen(this, TextInfoScreenOne, "bilibino-npp");
		infoScreen12 = new InfoScreen12(this, TextInfoScreenOneFinal, "bilibino-reactor");
		gameScreen = new GameScreen(this);
		sparklingWaterScreen = new SparklingWaterScreen(this);
		winScreen = new WinScreen(this);
		loseScreen = new LoseScreen(this);

		setScreen(menuScreen);

	}

	@Override
	public void dispose () {
		skin.dispose();
	}

}
