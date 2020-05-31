package figures.rectangle;

import figures.figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class rectangle extends figure {
    double width;
    double height;

    public rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(MouseEvent mouseEvent, GraphicsContext gc) {
        gc.strokeRect(x, y, mouseEvent.getX() - x, mouseEvent.getY() - y);
    }
}
