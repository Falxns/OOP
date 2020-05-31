package figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public interface drawable {
    void draw(MouseEvent mouseEvent, GraphicsContext gc);
}
