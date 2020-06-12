package Decorator;

import Serialization.Serialization;

public abstract class Decorator extends Serialization {
    protected Serialization serializ;

    public Serialization getSerializ() {
        return serializ;
    }

    public void setSerializ(Serialization serializ) {
        this.serializ = serializ;
    }
}
