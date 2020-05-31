package sample;

import figures.circle.circle;
import figures.ellipse.ellipse;
import figures.figure;
import figures.line.line;
import figures.rectangle.rectangle;
import figures.square.square;
import figures.triangle.triangle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button btnGo = new Button("PAINT");
        btnGo.setLayoutY(100);
        Group root = new Group(btnGo);
        EventHandler<MouseEvent> btnClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                line fLine = new line(0, 0, 100, 100);
                circle fCircle = new circle(150, 50, 50);
                square fSquare = new square(225, 25, 50);
                rectangle fRectangle = new rectangle(310, 25, 80, 50);
                ellipse fEllipse = new ellipse(450, 50, 50, 20);
                triangle fTriangle = new triangle(550, 0, 500, 100, 600, 100);
                ArrayList<figure> figures = new ArrayList<figure>();
                figures.add(fLine);
                figures.add(fCircle);
                figures.add(fSquare);
                figures.add(fRectangle);
                figures.add(fEllipse);
                figures.add(fTriangle);
                for (int i = 0; i < figures.size(); i++) {
                    figures.get(i).draw(root.getChildren());
                }
            }
        };
        btnGo.addEventFilter(MouseEvent.MOUSE_CLICKED, btnClick);
        primaryStage.setTitle("Lab1");
        primaryStage.setScene(new Scene(root, 600, 140));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
