package sample;

import Tanks.Tanks;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface IServ {
    Tanks doSmth();

    static List<IServ> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, IServ.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}