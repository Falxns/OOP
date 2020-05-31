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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    figure needed;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button btnLine = new Button("LINE");
        Button btnCircle = new Button("CIRCLE");
        btnCircle.setLayoutX(45);
        Button btnSquare = new Button("SQUARE");
        btnSquare.setLayoutX(105);
        Button btnRectangle = new Button("RECTANGLE");
        btnRectangle.setLayoutX(173);
        Button btnTriangle = new Button("TRIANGLE");
        btnTriangle.setLayoutX(260);
        Button btnEllipse = new Button("ELLIPSE");
        btnEllipse.setLayoutX(338);
        Canvas canvas1 = new Canvas(600, 550);
        Canvas canvas2 = new Canvas(600, 550);
        canvas1.setLayoutY(50);
        canvas2.setLayoutY(50);
        final GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        final GraphicsContext gc2 = canvas2.getGraphicsContext2D();
        Group root = new Group(btnLine, btnCircle, btnSquare, btnRectangle, btnTriangle, btnEllipse, canvas1, canvas2);
        canvas1.setOpacity(1);
        gc1.setLineWidth(3);
        gc2.setLineWidth(3);
        EventHandler<MouseEvent> drLine = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                line fLine = new line(0, 0, 0, 0);
                gc1.setStroke(Color.BLACK);
                gc2.setStroke(Color.BLACK);
                needed = fLine;
            }
        };
        btnLine.addEventHandler(MouseEvent.MOUSE_CLICKED, drLine);
        EventHandler<MouseEvent> drCircle = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                circle fCircle = new circle(0, 0, 0);
                gc1.setFill(Color.RED);
                gc2.setFill(Color.RED);
                needed = fCircle;
            }
        };
        btnCircle.addEventHandler(MouseEvent.MOUSE_CLICKED, drCircle);
        EventHandler<MouseEvent> drSquare = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                square fSquare = new square(0, 0, 0);
                gc1.setFill(Color.GRAY);
                gc2.setFill(Color.GRAY);
                needed = fSquare;
            }
        };
        btnSquare.addEventHandler(MouseEvent.MOUSE_CLICKED, drSquare);
        EventHandler<MouseEvent> drRectangle = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rectangle fRectangle = new rectangle(0, 0, 0, 0);
                gc1.setStroke(Color.BLUE);
                gc2.setStroke(Color.BLUE);
                needed = fRectangle;
            }
        };
        btnRectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, drRectangle);
        EventHandler<MouseEvent> drTriangle = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                triangle fTriangle = new triangle(0, 0, 0, 0, 0, 0);
                gc1.setFill(Color.YELLOW);
                gc2.setFill(Color.YELLOW);
                needed = fTriangle;
            }
        };
        btnTriangle.addEventHandler(MouseEvent.MOUSE_CLICKED, drTriangle);
        EventHandler<MouseEvent> drEllipse = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ellipse fEllipse = new ellipse(0, 0, 0, 0);
                gc1.setStroke(Color.VIOLET);
                gc2.setStroke(Color.VIOLET);
                needed = fEllipse;
            }
        };
        btnEllipse.addEventHandler(MouseEvent.MOUSE_CLICKED, drEllipse);
        EventHandler<MouseEvent> drawFigPress = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                needed.x = mouseEvent.getX();
                needed.y = mouseEvent.getY();
            }
        };
        EventHandler<MouseEvent> drawFigDrag = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gc2.clearRect(0,0,600,550);
                needed.draw(mouseEvent, gc2);
            }
        };
        EventHandler<MouseEvent> drawFigRelease = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                needed.draw(mouseEvent, gc1);
                gc2.clearRect(0,0,600,550);
            }
        };
        canvas2.addEventHandler(MouseEvent.MOUSE_PRESSED, drawFigPress);
        canvas2.addEventHandler(MouseEvent.MOUSE_DRAGGED, drawFigDrag);
        canvas2.addEventHandler(MouseEvent.MOUSE_RELEASED, drawFigRelease);
        primaryStage.setTitle("Lab2");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
