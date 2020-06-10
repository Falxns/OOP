package Tanks;

import sample.TankFormController;

public abstract class Tanks {
    public String name;
    public int weight;
    public Tanks(String name, int weight) {
        setName(name);
        setWeight(weight);
    }
    public Tanks(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    public abstract void setFields(TankFormController controller);
}
