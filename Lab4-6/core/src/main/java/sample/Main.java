package sample;

import Tanks.Tanks;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {
    public static LinkedList<Tanks> plugTanks = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
        primaryStage.setTitle("Lab4");
        primaryStage.setScene(new Scene(root, 400, 430));
        primaryStage.show();
    }

    private static void importTanks(String[] args) {
        Path pluginsDir = Paths.get("/Users/falxns/Downloads/OOP/Lab4-6/core/src/main/plugins");

        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());


        List<IServ> services = IServ.getServices(layer);
        for (IServ service : services) {
            plugTanks.add(service.doSmth());
        }
    }

    public static void main(String[] args) {
        importTanks(args);
        launch(args);
    }
}