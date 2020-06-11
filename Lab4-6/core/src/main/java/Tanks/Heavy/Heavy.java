package Tanks.Heavy;

import Tanks.Tanks;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import sample.Controller;
import sample.TableString;
import sample.TankFormController;

public class Heavy extends Tanks {
    private boolean haveArmorScreen;
    public Heavy(String name,int weight, boolean haveArmorScreen){
        super(name, weight);
        setHaveArmorScreen(haveArmorScreen);
    }
    public Heavy(){}

    public void setHaveArmorScreen(boolean haveArmorScreen) {
        this.haveArmorScreen = haveArmorScreen;
    }

    public boolean isHaveArmorScreen() {
        return haveArmorScreen;
    }

    @Override
    public String getTankName() { return "Heavy"; }

    @Override
    public void setFields(TankFormController controller) {
        setTankFields(controller);
        CheckBox armorScreen = new CheckBox("Has Armor Screen");
        armorScreen.setLayoutY(60);
        Button btnAdd = new Button("Edit");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                Heavy tank = new Heavy(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), armorScreen.isSelected());
                Controller.tableTanksList.set(Controller.selectedIndex, new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(armorScreen, btnAdd);
        controller.nameField.setText(this.getName());
        controller.weightField.setText(String.valueOf(this.getWeight()));
        armorScreen.setSelected(this.isHaveArmorScreen());
    }

    @Override
    public void setAddFields(TankFormController controller) {
        setTankFields(controller);
        CheckBox armorScreen = new CheckBox("Has Armor Screen");
        armorScreen.setLayoutY(60);
        Button btnAdd = new Button("Add");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                Heavy tank = new Heavy(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), armorScreen.isSelected());
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(armorScreen, btnAdd);
    }
}