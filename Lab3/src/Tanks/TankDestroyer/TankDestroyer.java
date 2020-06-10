package Tanks.TankDestroyer;

import Tanks.Light.Light;
import Tanks.Tanks;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import sample.Controller;
import sample.TableString;
import sample.TankFormController;

public class TankDestroyer extends Tanks {
    private boolean roundTower;
    public TankDestroyer(String name, int weight, boolean roundTower){
        super(name, weight);
        setRoundTower(roundTower);
    }
    public TankDestroyer(){}

    public void setRoundTower(boolean roundTower) {
        this.roundTower = roundTower;
    }
    public boolean isRoundTower(){
        return roundTower;
    }

    @Override
    public void setFields(TankFormController controller) {
        controller.setTankFields();
        CheckBox rounded = new CheckBox("Is tower round");
        rounded.setLayoutY(60);
        Button btnAdd = new Button("Edit");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                TankDestroyer tank = new TankDestroyer(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), rounded.isSelected());
                Controller.tableTanksList.set(Controller.selectedIndex, new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(rounded, btnAdd);
        controller.nameField.setText(this.getName());
        controller.weightField.setText(String.valueOf(this.getWeight()));
        rounded.setSelected(this.isRoundTower());
    }
}
