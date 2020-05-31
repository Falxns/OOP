package figures.triangle;

import figures.figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import static java.lang.Math.sqrt;

public class triangle extends figure {
    double xx;
    double yy;
    double xxx;
    double yyy;

    public triangle(double x, double y, double xx, double yy, double xxx, double yyy) {
        super(x, y);
        this.xx = xx;
        this.yy = yy;
        this.xxx = xxx;
        this.yyy = yyy;
    }
    @Override
    public void draw(MouseEvent mouseEvent, GraphicsContext gc) {
        gc.fillPolygon(new double[]{x, mouseEvent.getX(), x + (mouseEvent.getX() - x) / 2}, new double[]{y, y, y + (sqrt(3) * (mouseEvent.getX() - x) / 2)}, 3);
    }
}