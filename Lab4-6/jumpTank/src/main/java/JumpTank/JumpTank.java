package JumpTank;

import Tanks.Tanks;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Controller;
import sample.IServ;
import sample.TableString;
import sample.TankFormController;

public class JumpTank extends Tanks implements IServ {
    private int jumpHeight;
    public JumpTank(String name, int weight, int jumpHeight) {
        super(name, weight);
        setJumpHeight(jumpHeight);
    }
    public JumpTank(){}

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public String getTankName() { return "Jump Tank"; }

    @Override
    public void setFields(TankFormController controller) {
        setTankFields(controller);
        Label jumpHeightLabel = new Label("Jump height");
        jumpHeightLabel.setLayoutY(60);
        TextField jumpHeightField = new TextField();
        jumpHeightField.setLayoutX(40);
        jumpHeightField.setLayoutY(60);
        Button btnAdd = new Button("Edit");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty() || jumpHeightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                JumpTank tank = new JumpTank(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), Integer.parseInt(jumpHeightField.getText()));
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(jumpHeightLabel, jumpHeightField, btnAdd);
        controller.nameField.setText(this.getName());
        controller.weightField.setText(String.valueOf(this.getWeight()));
        jumpHeightField.setText(String.valueOf(this.getJumpHeight()));
    }

    @Override
    public void setAddFields(TankFormController controller) {
        setTankFields(controller);
        Label jumpHeightLabel = new Label("Jump height");
        jumpHeightLabel.setLayoutY(60);
        TextField jumpHeightField = new TextField();
        jumpHeightField.setLayoutX(40);
        jumpHeightField.setLayoutY(60);
        Button btnAdd = new Button("Add");
        btnAdd.setLayoutY(90);
        btnAdd.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.weightField.getText().trim().isEmpty() || jumpHeightField.getText().trim().isEmpty()) {
                return;
            }
            try {
                JumpTank tank = new JumpTank(controller.nameField.getText(), Integer.parseInt(controller.weightField.getText()), Integer.parseInt(jumpHeightField.getText()));
                Controller.tableTanksList.add(new TableString(tank, tank.name));
            } catch (Exception ex) {
                return;
            }
            Stage tmp = (Stage) btnAdd.getScene().getWindow();
            tmp.close();
        });
        controller.anchor.getChildren().addAll(jumpHeightLabel, jumpHeightField, btnAdd);
    }

    @Override
    public Tanks doSmth() {
        System.out.println("Jump tank plugin");
        return new JumpTank();
    }
}
