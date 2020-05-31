package figures.ellipse;

import figures.figure;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Ellipse;

public class ellipse extends figure {
    double radX;
    double radY;

    public ellipse(double x, double y, double radX, double radY) {
        super(x, y);
        this.radX = radX;
        this.radY = radY;
    }
    @Override
    public void draw(ObservableList<Node> root) {
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(this.x);
        ellipse.setCenterY(this.y);
        ellipse.setRadiusX(this.radX);
        ellipse.setRadiusY(this.radY);
        root.add(ellipse);
    }
}
