package gc.tutorial.chapt13;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author afsal villan
 * @version 1.0
 *
 * http://www.genuinecoder.com
 */
public class Earth extends Application {

  private static final float WIDTH = 1400;
  private static final float HEIGHT = 1000;

  @Override
  public void start(Stage primaryStage) {
    Camera camera = new PerspectiveCamera(true);
    camera.setNearClip(1);
    camera.setFarClip(1000);
    camera.translateZProperty().set(-1000);

    Group world = new Group();
    world.getChildren().add(prepareEarth());

    Scene scene = new Scene(world, WIDTH, HEIGHT, true);
    scene.setFill(Color.SILVER);
    scene.setCamera(camera);

    primaryStage.setTitle("Genuine Coder");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Node prepareEarth() {
    PhongMaterial earthMaterial = new PhongMaterial();
    earthMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/resources/earth/earth-d.jpg")));
    Sphere sphere = new Sphere(150);
    sphere.setMaterial(earthMaterial);
    return sphere;
  }
}
