package com.mygdx.game;

public class GameSettings {
    public static final int SCREEN_WIDTH = 1920;
    public static final int SCREEN_HEIGHT = 1080;
    public static final float STEP_TIME = 1f / 60f;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 6;
    public static final String SKIN_PATH = "nuke9/nuclear.json";

    // TextResources:
    public static final String TextInfoScreenOne = "On June 26, 1954, under the leadership of Igor Vasilyevich \n"
            + "Kurchatov, the world's first nuclear power plant with a 5 MW \n"
            + "power unit and an AM-1 reactor was launched in Obninsk. \n"
            + "The name of the reactor stands for Atom Mirny and means \n"
            + "that nuclear energy can also be used to improve the quality \n"
            + "of human life. After the first steam was supplied to the turbine, \n"
            + "the workers congratulated each other: “Happy steam! »";

    public static final String TextInfoScreenOneFinal = "The reactor was shut down in 2002, but complete decommissioning of the nuclear power plant took another 13 years. As a result, the station operated for 48 years. Now it is equipped as a research complex.";

    public static final String TextInfoScreenTwo = "";

    public static final String[] tutorialTexts = new String[]{
            "",
            "",
            "",
    };

}
