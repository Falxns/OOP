package figures.line;

import figures.figure;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Line;

public class line extends figure {
    double xx;
    double yy;
    public line(double x, double y, double xx, double yy) {
        super(x, y);
        this.xx = xx;
        this.yy = yy;
    }
    @Override
    public void draw(ObservableList<Node> root) {
        Line line = new Line();
        line.setStartX(this.x);
        line.setStartY(this.y);
        line.setEndX(this.xx);
        line.setEndY(this.yy);
        root.add(line);
    }
}
