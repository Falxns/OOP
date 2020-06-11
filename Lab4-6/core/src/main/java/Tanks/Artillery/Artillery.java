package Tanks.Artillery;

import Tanks.Tanks;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Controller;
import sample.TableString;
import sample.TankFormController;

public class Artillery extends Tanks {
    private int arcOfFire;
    public Artillery(String name, int weight, int arcOfFire){
        super(name, weight);
        setArcOfFire(arcOfFire);
    }
    public Artillery(){}

    public void setArcOfFire(int arcOfFire) {
        this.arcOfFire = arcOfFire;
    }

    public int getArcOfFire() {
        return arcOfFire;
    }

    @Override
    public String getTankName() { return "Artillery"; }

    @Override
    public void setFields(TankFormController controller) {
        setTankFields(controller);
        Label arcLabel = new Label("Arc of Fire");
        arcLabel.setLayoutY(60);
        TextField arcOfFire = new TextField();
        arcOfFire.setLayoutX(60);
        arcOfFire.setLayoutY(60);
        Button btnAdd = new Button("Edit");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty() || arcOfFire.getText().trim().isEmpty()) {
                return;
            }
            try {
                Artillery tank = new Artillery(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), Integer.parseInt(arcOfFire.getText()));
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(arcLabel, arcOfFire, btnAdd);
        controller.nameField.setText(this.getName());
        controller.weightField.setText(String.valueOf(this.getWeight()));
        arcOfFire.setText(String.valueOf(this.getArcOfFire()));
    }

    @Override
    public void setAddFields(TankFormController controller) {
        setTankFields(controller);
        Label arcLabel = new Label("Arc of Fire");
        arcLabel.setLayoutY(60);
        TextField arcOfFire = new TextField();
        arcOfFire.setLayoutX(60);
        arcOfFire.setLayoutY(60);
        Button btnAdd = new Button("Add");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty() || arcOfFire.getText().trim().isEmpty()) {
                return;
            }
            try {
                Artillery tank = new Artillery(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), Integer.parseInt(arcOfFire.getText()));
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(arcLabel, arcOfFire, btnAdd);
    }
}