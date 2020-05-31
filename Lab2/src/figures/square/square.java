package figures.square;

import figures.figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class square extends figure {
    double side;

    public square(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }
    @Override
    public void draw(MouseEvent mouseEvent, GraphicsContext gc) {
        gc.fillRect(x, y, mouseEvent.getX() - x, mouseEvent.getX() - x);
    }
}
