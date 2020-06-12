package Adapter;

import Encryption.Encryption;
import Tanks.Tanks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class AdapterForEncryption extends Adapter {
    private Encryption encryption = Encryption.getInstance();

    public AdapterForEncryption() {}

    @Override
    public String getFileName() { return serializ.getFileName(); }

    @Override
    public void saveInFile(LinkedList<Tanks> tanks) throws Exception {
        serializ.saveInFile(tanks);
        File file = new File(serializ.getFileName());
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = fileInputStream.readAllBytes();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] res = encryption.Encrypt(data);
        fileOutputStream.write(res);
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Override
    public LinkedList<Tanks> readFromFile() throws Exception {
        File file = new File(serializ.getFileName());
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = fileInputStream.readAllBytes();
        byte[] res = encryption.Decrypt(data);
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(res);
        fileOutputStream.close();

        return serializ.readFromFile();
    }
}
