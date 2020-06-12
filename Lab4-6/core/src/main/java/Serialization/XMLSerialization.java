package Serialization;

import Tanks.Tanks;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class XMLSerialization extends Serialization {
    private final String fileName = "Data.xml";

    public XMLSerialization() {
        setNameOfSerialization("XML");
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void saveInFile(LinkedList<Tanks> tanks) throws Exception {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        for (Tanks tank : tanks) {
            encoder.writeObject(tank);
        }
        encoder.close();
    }

    @Override
    public LinkedList<Tanks> readFromFile() throws Exception {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
        LinkedList<Tanks> result = new LinkedList<>();
        while (true) {
            try {
                result.add((Tanks) decoder.readObject());
            } catch (ArrayIndexOutOfBoundsException ex) {
                decoder.close();
                break;
            }
        }
        return result;
    }
}
