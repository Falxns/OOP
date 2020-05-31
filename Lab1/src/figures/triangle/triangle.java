package figures.triangle;

import figures.figure;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;

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
    public void draw(ObservableList<Node> root) {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{this.x, this.y, this.xx, this.yy, this.xxx, this.yyy});
        root.add(triangle);
    }
}
