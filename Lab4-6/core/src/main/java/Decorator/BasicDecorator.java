package Decorator;

import Tanks.Tanks;

import java.util.LinkedList;

public class BasicDecorator extends Decorator {

    @Override
    public String getFileName() {
        return serializ.getFileName();
    }

    @Override
    public void saveInFile(LinkedList<Tanks> tanks) throws Exception {
        serializ.saveInFile(tanks);
    }

    @Override
    public LinkedList<Tanks> readFromFile() throws Exception {
        return serializ.readFromFile();
    }
}
