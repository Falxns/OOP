package Tanks;

import Observer.Observers;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.TankFormController;

public abstract class Tanks {
    public String name;
    public int weight;
    public static Observers observers = new Observers();
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

    public abstract String getTankName();

    public void setTankFields(TankFormController controller) {
        Label nameLabel = new Label("Name");
        controller.nameField = new TextField();
        controller.nameField.setLayoutX(40);
        Label weightLabel = new Label("Weight");
        weightLabel.setLayoutY(30);
        controller.weightField = new TextField();
        controller.weightField.setLayoutX(50);
        controller.weightField.setLayoutY(30);
        controller.anchor.getChildren().addAll(nameLabel,controller.nameField,weightLabel,controller.weightField);
    }

    public abstract void setFields(TankFormController controller);

    public abstract void setAddFields(TankFormController controller);
}