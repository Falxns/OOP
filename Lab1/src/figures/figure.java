package figures;

public abstract class figure implements drawable {
    public double x;
    public double y;

    public figure(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
