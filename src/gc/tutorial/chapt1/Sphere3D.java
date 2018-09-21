package gc.tutorial.chapt1;

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
public class Sphere3D extends Application {

  private static final int WIDTH = 1400;
  private static final int HEIGHT = 800;

  @Override
  public void start(Stage primaryStage) {
    Sphere sphere = new Sphere(50);

    Group group = new Group();
    group.getChildren().add(sphere);

    Camera camera = new PerspectiveCamera();
    Scene scene = new Scene(group, WIDTH, HEIGHT);
    scene.setFill(Color.SILVER);
    scene.setCamera(camera);

    sphere.translateXProperty().set(WIDTH / 2);
    sphere.translateYProperty().set(HEIGHT / 2);

    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case W:
          sphere.translateZProperty().set(sphere.getTranslateZ() + 100);
          break;
        case S:
          sphere.translateZProperty().set(sphere.getTranslateZ() - 100);
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
