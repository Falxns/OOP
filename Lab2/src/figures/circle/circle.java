package figures.circle;

import figures.figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class circle extends figure {
    double rad;
    public circle(double x, double y, double rad) {
        super(x, y);
        this.rad = rad;
    }
    @Override
    public void draw(MouseEvent mouseEvent, GraphicsContext gc) {
        gc.fillOval(x, y, mouseEvent.getX() - x, mouseEvent.getX() - x);
    }
}
