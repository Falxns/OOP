package sample;

import Tanks.Artillery.Artillery;
import Tanks.Heavy.Heavy;
import Tanks.Light.Light;
import Tanks.Medium.Medium;
import Tanks.TankDestroyer.TankDestroyer;
import Tanks.Tanks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.util.HashMap;
import java.util.Map;

public class TankFormController {
    public Map<String, Creator> createTable = new HashMap<>();
    public TextField nameField, weightField;
    @FXML
    public AnchorPane anchor;
    @FXML
    public ComboBox<String> tankSelector;

    @FXML
    private void initialize() {
        if (Controller.isEdit) {
            anchor.getChildren().clear();
            Controller.tableTanksList.get(Controller.selectedIndex).getTank().setFields(this);
            Controller.isEdit = false;
        } else {
            createTable.put("Light", () -> {
                (new Light()).setAddFields(this);
            });
            createTable.put("Medium", () -> {
                (new Medium()).setAddFields(this);
            });
            createTable.put("Heavy", () -> {
                (new Heavy()).setAddFields(this);
            });
            createTable.put("Tank Destroyer", () -> {
                (new TankDestroyer()).setAddFields(this);
            });
            createTable.put("Artillery", () -> {
                (new Artillery()).setAddFields(this);
            });
            ObservableList<String> tanksList = FXCollections.observableArrayList("Light", "Medium", "Heavy", "Tank Destroyer", "Artillery");
            for (Tanks tank : Main.plugTanks) {
                if (tank != null) {
                    tanksList.add(tank.getTankName());
                    createTable.put(tank.getTankName(), () -> {
                        tank.setAddFields(this);
                    });
                }
            }
            tankSelector.setItems(tanksList);
            tankSelector.setValue("Tank");
        }
    }

    public void tankSelect() {
        anchor.getChildren().clear();
        createTable.get(tankSelector.getValue()).createTank();
    }
}