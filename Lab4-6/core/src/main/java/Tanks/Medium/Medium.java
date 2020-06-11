package Tanks.Medium;

import Tanks.Tanks;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import sample.Controller;
import sample.TableString;
import sample.TankFormController;

public class Medium extends Tanks {
    private boolean haveAPDS;
    public Medium(String name,int weight, boolean haveAPDS){
        super(name, weight);
        setHaveAPDS(haveAPDS);
    }
    public Medium(){}

    public void setHaveAPDS(boolean haveAPDS) {
        this.haveAPDS = haveAPDS;
    }

    public boolean isHaveAPDS() {
        return haveAPDS;
    }

    @Override
    public String getTankName() { return "Medium"; }

    @Override
    public void setFields(TankFormController controller) {
        setTankFields(controller);
        CheckBox APDS = new CheckBox("Has nitro");
        APDS.setLayoutY(60);
        Button btnAdd = new Button("Edit");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                Medium tank = new Medium(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), APDS.isSelected());
                Controller.tableTanksList.set(Controller.selectedIndex, new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(APDS, btnAdd);
        controller.nameField.setText(this.getName());
        controller.weightField.setText(String.valueOf(this.getWeight()));
        APDS.setSelected(this.isHaveAPDS());
    }

    @Override
    public void setAddFields(TankFormController controller) {
        setTankFields(controller);
        CheckBox APDS = new CheckBox("Has APDS");
        APDS.setLayoutY(60);
        Button btnAdd = new Button("Add");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                Medium tank = new Medium(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), APDS.isSelected());
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(APDS, btnAdd);
    }
}