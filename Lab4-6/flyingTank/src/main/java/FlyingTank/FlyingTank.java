package FlyingTank;

import Tanks.Tanks;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Controller;
import sample.IServ;
import sample.TableString;
import sample.TankFormController;

public class FlyingTank extends Tanks implements IServ {
    private int flightTime;
    public FlyingTank(String name, int weight, int flightTime) {
        super(name, weight);
        setFlightTime(flightTime);
    }
    public FlyingTank(){}

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public int getFlightTime() {
        return flightTime;
    }

    @Override
    public String getTankName() { return "Flying Tank"; }

    @Override
    public void setFields(TankFormController controller) {
        setTankFields(controller);
        Label flightTimeLabel = new Label("Flight time");
        flightTimeLabel.setLayoutY(60);
        TextField flightTimeField = new TextField();
        flightTimeField.setLayoutX(40);
        flightTimeField.setLayoutY(60);
        Button btnAdd = new Button("Edit");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty() || flightTimeField.getText().trim().isEmpty()) {
                return;
            }
            try {
                FlyingTank tank = new FlyingTank(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), Integer.parseInt(flightTimeField.getText()));
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(flightTimeLabel, flightTimeField, btnAdd);
        controller.nameField.setText(this.getName());
        controller.weightField.setText(String.valueOf(this.getWeight()));
        flightTimeField.setText(String.valueOf(this.getFlightTime()));
    }

    @Override
    public void setAddFields(TankFormController controller) {
        setTankFields(controller);
        Label flightTimeLabel = new Label("Flight time");
        flightTimeLabel.setLayoutY(60);
        TextField flightTimeField = new TextField();
        flightTimeField.setLayoutX(40);
        flightTimeField.setLayoutY(60);
        Button btnAdd = new Button("Add");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty() || flightTimeField.getText().trim().isEmpty()) {
                return;
            }
            try {
                FlyingTank tank = new FlyingTank(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), Integer.parseInt(flightTimeField.getText()));
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(flightTimeLabel, flightTimeField, btnAdd);
    }

    @Override
    public Tanks doSmth() {
        System.out.println("Flying tank plugin");
        return new FlyingTank();
    }
}