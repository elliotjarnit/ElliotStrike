package dev.elliotjarnit.elliotstrike;

import dev.elliotjarnit.elliotengine.ElliotEngine;

public class Main extends ElliotEngine {
    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void optionSetup() {
        setOption(Options.NAME, "Elliot Strike");
        setOption(Options.AUTHOR, "Elliot Jarnit-Bjergsoe");
        setOption(Options.DESCRIPTION, "A 3D FPS game made with ElliotEngine");
        setOption(Options.VERSION, getClass().getPackage().getImplementationVersion());
        setOption(Options.WINDOW_WIDTH, String.valueOf(1280));
        setOption(Options.WINDOW_HEIGHT, String.valueOf(720));
        // Check if running from jar
        if (this.getClass().getResource("Main.class").toString().startsWith("jar")) {
            this.setOption(Options.LOADING_SCREEN, "true");
        } else {
            this.setOption(Options.LOADING_SCREEN, "false");
        }
    }

    @Override
    public void setup() {

    }

    @Override
    public void loop() {

    }
}