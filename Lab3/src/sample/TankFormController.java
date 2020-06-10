package sample;

import Tanks.Artillery.Artillery;
import Tanks.Heavy.Heavy;
import Tanks.Light.Light;
import Tanks.Medium.Medium;
import Tanks.TankDestroyer.TankDestroyer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class TankFormController {
    public Map<String, Creator> createTable = new HashMap<>();
    public TextField nameField, weightField;
    @FXML
    public AnchorPane anchor;
    @FXML
    public ComboBox<String> tankSelector;

    public void setTankFields() {
        Label nameLabel = new Label("Name");
        nameField = new TextField();
        nameField.setLayoutX(40);
        Label weightLabel = new Label("Weight");
        weightLabel.setLayoutY(30);
        weightField = new TextField();
        weightField.setLayoutX(50);
        weightField.setLayoutY(30);
        anchor.getChildren().addAll(nameLabel,nameField,weightLabel,weightField);
    }
    @FXML
    private void initialize() {
        if (Controller.isEdit) {
            anchor.getChildren().clear();
            Controller.tableTanksList.get(Controller.selectedIndex).getTank().setFields(this);
            Controller.isEdit = false;
        } else {
            createTable.put("Light", () -> {
                setTankFields();
                CheckBox nitro = new CheckBox("Has nitro");
                nitro.setLayoutY(60);
                Button btnAdd = new Button("Add");
                btnAdd.setLayoutY(90);
                btnAdd.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty() || weightField.getText().trim().isEmpty()) {
                        return;
                    }
                    try {
                        Light tank = new Light(nameField.getText(), Integer.parseInt(weightField.getText()), nitro.isSelected());
                        Controller.tableTanksList.add(new TableString(tank, tank.name));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage tmp = (Stage) btnAdd.getScene().getWindow();
                    tmp.close();
                });
                anchor.getChildren().addAll(nitro, btnAdd);
            });
            createTable.put("Medium", () -> {
                setTankFields();
                CheckBox APDS = new CheckBox("Has APDS");
                APDS.setLayoutY(60);
                Button btnAdd = new Button("Add");
                btnAdd.setLayoutY(90);
                btnAdd.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty() || weightField.getText().trim().isEmpty()) {
                        return;
                    }
                    try {
                        Medium tank = new Medium(nameField.getText(), Integer.parseInt(weightField.getText()), APDS.isSelected());
                        Controller.tableTanksList.add(new TableString(tank, tank.name));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage tmp = (Stage) btnAdd.getScene().getWindow();
                    tmp.close();
                });
                anchor.getChildren().addAll(APDS, btnAdd);
            });
            createTable.put("Heavy", () -> {
                setTankFields();
                CheckBox armorScreen = new CheckBox("Has Armor Screen");
                armorScreen.setLayoutY(60);
                Button btnAdd = new Button("Add");
                btnAdd.setLayoutY(90);
                btnAdd.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty() || weightField.getText().trim().isEmpty()) {
                        return;
                    }
                    try {
                        Heavy tank = new Heavy(nameField.getText(), Integer.parseInt(weightField.getText()), armorScreen.isSelected());
                        Controller.tableTanksList.add(new TableString(tank, tank.name));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage tmp = (Stage) btnAdd.getScene().getWindow();
                    tmp.close();
                });
                anchor.getChildren().addAll(armorScreen, btnAdd);
            });
            createTable.put("Tank Destroyer", () -> {
                setTankFields();
                CheckBox rounded = new CheckBox("Is tower round");
                rounded.setLayoutY(60);
                Button btnAdd = new Button("Add");
                btnAdd.setLayoutY(90);
                btnAdd.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty() || weightField.getText().trim().isEmpty()) {
                        return;
                    }
                    try {
                        TankDestroyer tank = new TankDestroyer(nameField.getText(), Integer.parseInt(weightField.getText()), rounded.isSelected());
                        Controller.tableTanksList.add(new TableString(tank, tank.name));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage tmp = (Stage) btnAdd.getScene().getWindow();
                    tmp.close();
                });
                anchor.getChildren().addAll(rounded, btnAdd);
            });
            createTable.put("Artillery", () -> {
                setTankFields();
                Label arcLabel = new Label("Arc of Fire");
                arcLabel.setLayoutY(60);
                TextField arcOfFire = new TextField();
                arcOfFire.setLayoutX(60);
                arcOfFire.setLayoutY(60);
                Button btnAdd = new Button("Add");
                btnAdd.setLayoutY(90);
                btnAdd.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty() || weightField.getText().trim().isEmpty() || arcOfFire.getText().trim().isEmpty()) {
                        return;
                    }
                    try {
                        Artillery tank = new Artillery(nameField.getText(), Integer.parseInt(weightField.getText()), Integer.parseInt(arcOfFire.getText()));
                        Controller.tableTanksList.add(new TableString(tank, tank.name));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage tmp = (Stage) btnAdd.getScene().getWindow();
                    tmp.close();
                });
                anchor.getChildren().addAll(arcLabel, arcOfFire, btnAdd);
            });
            ObservableList<String> tanksList = FXCollections.observableArrayList("Light", "Medium", "Heavy", "Tank Destroyer", "Artillery");
            tankSelector.setItems(tanksList);
            tankSelector.setValue("Tank");
        }
    }

    public void tankSelect() {
        anchor.getChildren().clear();
        createTable.get(tankSelector.getValue()).createTank();
    }
}
