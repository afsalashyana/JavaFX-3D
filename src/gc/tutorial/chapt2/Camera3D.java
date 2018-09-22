package gc.tutorial.chapt2;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author afsal villan
 * @version 1.0
 *
 * http://www.genuinecoder.com
 */
public class Camera3D extends Application {

  private static final int WIDTH = 1400;
  private static final int HEIGHT = 800;

  @Override
  public void start(Stage primaryStage) {
    Sphere sphere = new Sphere(50);

    Group group = new Group();
    group.getChildren().add(sphere);

    Camera camera = new PerspectiveCamera(true);
    Scene scene = new Scene(group, WIDTH, HEIGHT);
    scene.setFill(Color.SILVER);
    scene.setCamera(camera);

    camera.translateZProperty().set(-500);

    camera.setNearClip(1);
    camera.setFarClip(1000);

    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case W:
          camera.translateZProperty().set(camera.getTranslateZ() + 100);
          break;
        case S:
          camera.translateZProperty().set(camera.getTranslateZ() - 100);
          break;
      }
    });

    primaryStage.setTitle("Genuine Coder");
    primaryStage.setScene(scene);
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
