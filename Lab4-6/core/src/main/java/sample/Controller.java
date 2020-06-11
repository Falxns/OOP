package sample;

import Tanks.Tanks;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Controller {
    public static ObservableList<TableString> tableTanksList = FXCollections.observableArrayList();
    public static int selectedIndex;
    public static boolean isEdit;
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
    }

    public void saveInFile() throws IOException {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Data.xml")));
        for (TableString str : tableRec.getItems()) {
            encoder.writeObject(str.getTank());
        }
        encoder.close();
    }

    public void readFromFile() throws IOException {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Data.xml")));
        tableTanksList.clear();
        while (true) {
            try {
                Tanks temp = (Tanks) decoder.readObject();
                tableTanksList.add(new TableString(temp, temp.getName()));
            } catch (ArrayIndexOutOfBoundsException ex) {
                decoder.close();
                break;
            }
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