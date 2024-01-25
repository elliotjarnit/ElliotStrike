package dev.elliotjarnit.elliotstrike.Scenes;

import dev.elliotjarnit.elliotengine.ElliotEngine;
import dev.elliotjarnit.elliotengine.Objects.ECamera;
import dev.elliotjarnit.elliotengine.Objects.EScene;
import dev.elliotjarnit.elliotengine.Utils.Vector2;
import dev.elliotjarnit.elliotengine.Window.InputManager;

public class DevLevel extends EScene {
        private ECamera camera;

        public DevLevel() {
            super(true);

            // Drop in unmodeled camera
            camera = new ECamera();
            this.setCamera(camera);
        }

        public void update(ElliotEngine engine) {
            if (engine.inputManager.isKeyPressed(InputManager.Key.W)) {
                camera.moveForward(0.5f);
            }

            if (engine.inputManager.isKeyPressed(InputManager.Key.S)) {
                camera.moveBackward(0.5f);
            }

            if (engine.inputManager.isKeyPressed(InputManager.Key.A)) {
                camera.moveLeft(0.5f);
            }

            if (engine.inputManager.isKeyPressed(InputManager.Key.D)) {
                camera.moveRight(0.5f);
            }

            if (engine.inputManager.isKeyPressed(InputManager.Key.SPACE)) {
                camera.moveUp(0.5f);
            }

            if (engine.inputManager.isKeyPressed(InputManager.Key.SHIFT)) {
                camera.moveDown(0.5f);
            }

            Vector2 mouseDelta = engine.inputManager.getMouseDelta();
            camera.setRotationDegrees(camera.getRotationDegrees().add(new Vector2(mouseDelta.y * 0.3, mouseDelta.x * 0.3)));
        }
}
