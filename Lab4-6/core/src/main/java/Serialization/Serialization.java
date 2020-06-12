package Serialization;

import Tanks.Tanks;

import java.util.LinkedList;

public abstract class Serialization {
    public String nameOfSerialization;
    public abstract void saveInFile(LinkedList<Tanks> tanks) throws Exception;
    public abstract LinkedList<Tanks> readFromFile() throws Exception;
    public abstract String getFileName();

    public String getNameOfSerialization() {
        return nameOfSerialization;
    }

    public void setNameOfSerialization(String nameOfSerialization) {
        this.nameOfSerialization = nameOfSerialization;
    }
}
