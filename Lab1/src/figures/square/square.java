package figures.square;

import figures.figure;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class square extends figure {
    double side;

    public square(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }
    @Override
    public void draw(ObservableList<Node> root) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(this.x);
        rectangle.setY(this.y);
        rectangle.setWidth(this.side);
        rectangle.setHeight(this.side);
        root.add(rectangle);
    }
}
