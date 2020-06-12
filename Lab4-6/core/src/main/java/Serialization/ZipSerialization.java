package Serialization;

import Decorator.Decorator;
import Tanks.Tanks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipSerialization extends Decorator {
    private final String fileName = "Archive.zip";

    public ZipSerialization() {
        setNameOfSerialization("ZIP");
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void saveInFile(LinkedList<Tanks> tanks) throws Exception {
        serializ.saveInFile(tanks);
        String dataFile = serializ.getFileName();
        FileOutputStream fos = new FileOutputStream(fileName);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(dataFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

    @Override
    public LinkedList<Tanks> readFromFile() throws Exception {
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileName));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = new File(zipEntry.getName());
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();

        return  serializ.readFromFile();
    }
}
