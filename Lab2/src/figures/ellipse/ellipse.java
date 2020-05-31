package figures.ellipse;

import figures.figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class ellipse extends figure {
    double radX;
    double radY;

    public ellipse(double x, double y, double radX, double radY) {
        super(x, y);
        this.radX = radX;
        this.radY = radY;
    }
    @Override
    public void draw(MouseEvent mouseEvent, GraphicsContext gc) {
        gc.strokeOval(x, y, mouseEvent.getX() - x, mouseEvent.getY() - y);
    }
}
