package tawsor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CleanAnimationApp extends Application {

    private static final double WINDOW_WIDTH = 800;
    private static final double WINDOW_HEIGHT = 600;
    private static final double BALL_RADIUS = 15;

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #10131a, #1b2230);");

        Circle circle = new Circle(BALL_RADIUS, Color.CORNFLOWERBLUE);
        circle.setStroke(Color.WHITE);
        circle.setStrokeWidth(1);
        circle.setCenterX(100);
        circle.setCenterY(100);

        Rectangle rectangle = new Rectangle(30, 30);
        rectangle.setFill(Color.WHITE);

        root.getChildren().add(rectangle);

        Scene scene = getScene(root, rectangle);

        stage.setTitle("Ball Mouse");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static Scene getScene(Pane root, Rectangle rectangle) {
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        scene.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();

            if (x < BALL_RADIUS) x = BALL_RADIUS;
            if (x > WINDOW_WIDTH - BALL_RADIUS) x = WINDOW_WIDTH - BALL_RADIUS;
            if (y < BALL_RADIUS) y = BALL_RADIUS;
            if (y > WINDOW_HEIGHT - BALL_RADIUS) y = WINDOW_HEIGHT - BALL_RADIUS;

            rectangle.setX(x);
            rectangle.setY(y);
        });
        return scene;
    }

    static void main(String[] args) {
        launch(args);
    }
}