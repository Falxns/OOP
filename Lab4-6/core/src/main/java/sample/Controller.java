package sample;

import Decorator.Decorator;
import Decorator.BasicDecorator;
import Serialization.Serialization;
import Serialization.XMLSerialization;
import Serialization.ZipSerialization;
import Tanks.Tanks;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.*;
import java.util.LinkedList;

public class Controller {
    public static ObservableList<TableString> tableTanksList = FXCollections.observableArrayList();
    public static int selectedIndex;
    public static boolean isEdit;
    private Serialization serialization = new XMLSerialization();
    private Decorator decorator = new BasicDecorator();
    @FXML
    private AnchorPane anchor;
    @FXML
    private TableView<TableString> tableRec;
    @FXML
    private TableColumn<TableString, Object> tableTank;
    @FXML
    private TableColumn<TableString, String> tableTankName;

    @FXML
    private void initialize() {
        tableTank.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getTank()));
        tableTankName.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getTankName()));
        tableRec.setItems(tableTanksList);
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rbXML = new RadioButton("XML");
        rbXML.setSelected(true);
        rbXML.setLayoutY(440);
        rbXML.setLayoutX(5);
        rbXML.setToggleGroup(toggleGroup);
        rbXML.setOnAction((ActionEvent) -> {
            decorator = new BasicDecorator();
        });
        RadioButton rbZIP = new RadioButton("ZIP");
        rbZIP.setLayoutY(440);
        rbZIP.setLayoutX(60);
        rbZIP.setToggleGroup(toggleGroup);
        rbZIP.setOnAction((ActionEvent) -> {
            decorator = new ZipSerialization();
        });
        anchor.getChildren().addAll(rbXML,rbZIP);
    }

    public void saveInFile() throws Exception {
        LinkedList<Tanks> tanks = new LinkedList<>();
        for (TableString str : tableRec.getItems()) {
            tanks.add(str.getTank());
        }
        decorator.setSerializ(serialization);
        decorator.saveInFile(tanks);
    }

    public void readFromFile() throws Exception {
        tableTanksList.clear();
        LinkedList<Tanks> result;
        decorator.setSerializ(serialization);
        result = decorator.readFromFile();
        for (Tanks tank : result) {
            tableTanksList.add(new TableString(tank, tank.getName()));
        }
    }

    public void addRecord() throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("tankForm.fxml"));
        newStage.setTitle("Add a Tank");
        newStage.setScene(new Scene(root, 220,200));
        newStage.show();
    }

    public void editRecord() throws IOException {
        selectedIndex = tableRec.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            isEdit = true;
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("tankForm.fxml"));
            newStage.setTitle("Edit Tank");
            newStage.setScene(new Scene(root, 220,200));
            newStage.show();
        }
    }

    public void deleteRecord() {
        selectedIndex = tableRec.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            tableRec.getItems().remove(selectedIndex);
        }
    }
}