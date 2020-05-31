package figures.rectangle;

import figures.figure;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class rectangle extends figure {
    double width;
    double height;

    public rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(ObservableList<Node> root) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(this.x);
        rectangle.setY(this.y);
        rectangle.setWidth(this.width);
        rectangle.setHeight(this.height);
        root.add(rectangle);
    }
}
