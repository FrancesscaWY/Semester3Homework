package lab1.example.lab1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import java.util.Locale;

//import static javafx.application.Application.launch;


public class RectangleApp extends Application{
    double i=0.1;
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(500, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Rectangle rect = new Rectangle(200,200,20,10);
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(10),e->{
            draw(gc,rect);
            rect.rotate(2);
            double x = 200+100*Math.cos(i);
            double y = 200+100*Math.sin(i)*Math.cos(i);
            rect.moveTo(x,y);
            i+=0.01;
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Group root = new Group();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root,500,400);
        primaryStage.setTitle("Rectangle Rotating");
        primaryStage.setScene(scene)    ;
        primaryStage.show();
    }
    private void draw(GraphicsContext gc,Rectangle rect){
        gc.clearRect(0,0,500,400);
        gc.save();
        gc.translate(rect.getCenterX(),rect.getCenterY());
        gc.rotate(rect.getAngle());
        gc.setFill(Color.BLUE);
        gc.fillRect(-rect.getWidth()/2,-rect.getHeight()/2,rect.getWidth(),rect.getHeight());
        gc.restore();
    }
    public static void main(String[] args){
        Locale.setDefault(new Locale.Builder().setLanguage("en").setRegion("US").build());
        launch(args);
    }

}
