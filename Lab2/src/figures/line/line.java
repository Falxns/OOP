package figures.line;

import figures.figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class line extends figure {
    double xx;
    double yy;
    public line(double x, double y, double xx, double yy) {
        super(x, y);
        this.xx = xx;
        this.yy = yy;
    }
    @Override
    public void draw(MouseEvent mouseEvent, GraphicsContext gc) {
        gc.strokeLine(x, y, mouseEvent.getX(), mouseEvent.getY());
    }
}
