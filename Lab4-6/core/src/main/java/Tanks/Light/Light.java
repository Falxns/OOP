package Tanks.Light;

import Tanks.Tanks;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import sample.Controller;
import sample.TableString;
import sample.TankFormController;

public class Light extends Tanks {
    private boolean haveNitro;
    public Light(String name, int weight, boolean haveNitro){
        super(name, weight);
        setHaveNitro(haveNitro);
    }
    public Light(){}

    public void setHaveNitro(boolean haveNitro) {
        this.haveNitro = haveNitro;
    }
    public boolean isHaveNitro() {
        return haveNitro;
    }

    @Override
    public String getTankName() { return "Light"; }

    @Override
    public void setFields(TankFormController controller) {
        setTankFields(controller);
        CheckBox nitro = new CheckBox("Has nitro");
        nitro.setLayoutY(60);
        Button btnAdd = new Button("Edit");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                Light tank = new Light(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), nitro.isSelected());
                Controller.tableTanksList.set(Controller.selectedIndex, new TableString(tank, tank.name));
                observers.notifyObjectChanged(this);
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(nitro, btnAdd);
        controller.nameField.setText(this.getName());
        controller.weightField.setText(String.valueOf(this.getWeight()));
        nitro.setSelected(this.isHaveNitro());
    }

    @Override
    public void setAddFields(TankFormController controller) {
        setTankFields(controller);
        CheckBox nitro = new CheckBox("Has nitro");
        nitro.setLayoutY(60);
        Button btnAdd = new Button("Add");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                Light tank = new Light(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), nitro.isSelected());
                Controller.tableTanksList.add(new TableString(tank, tank.name));
                observers.notifyObjectCreated(this);
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(nitro, btnAdd);
    }
}