package figures.circle;

import figures.figure;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class circle extends figure {
    double rad;
    public circle(double x, double y, double rad) {
        super(x, y);
        this.rad = rad;
    }
    @Override
    public void draw(ObservableList<Node> root) {
        Circle circle = new Circle();
        circle.setCenterX(this.x);
        circle.setCenterY(this.y);
        circle.setRadius(this.rad);
        root.add(circle);
    }
}
