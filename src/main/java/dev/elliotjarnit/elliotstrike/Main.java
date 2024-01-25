package dev.elliotjarnit.elliotstrike;

import dev.elliotjarnit.elliotengine.ElliotEngine;
import dev.elliotjarnit.elliotengine.Objects.EScene;
import dev.elliotjarnit.elliotstrike.Scenes.DevLevel;

public class Main extends ElliotEngine {
    private EScene mainLevel;
    private DevLevel devLevel;
    private boolean devMode = false;

    public static void main(String[] args) {
        System.out.println("Elliot Strike v" + Main.class.getPackage().getImplementationVersion());
        Main gameInstance = new Main();
        gameInstance.run();
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
            this.setOption(Options.VERSION, "DEVELOPER");
        }
    }

    @Override
    public void setup() {
        this.mainLevel = new EScene();
        this.devLevel = new DevLevel();

        this.setScene(this.mainLevel);

        if (this.getOption(Options.VERSION).equals("DEVELOPER")) {
            this.useDevLevel();
            this.devMode = true;
        }

        this.inputManager.takeoverMouse();
    }

    @Override
    public void loop() {
        if (devMode) {
            this.devLevel.update(this);
        }
    }

    public void useDevLevel() {
        this.setScene(this.devLevel);
    }
}