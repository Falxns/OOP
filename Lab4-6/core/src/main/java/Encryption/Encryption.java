package Encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    private static Encryption instance;
    public static Encryption getInstance(){ // #3
        if(instance == null){
            instance = new Encryption();
        }
        return instance;
    }

    private SecretKey secretKey;

    private Encryption(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            this.secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }



    public byte[] Encrypt(byte[] text) {
        byte[] encipherText = makeAes(text, Cipher.ENCRYPT_MODE);
        return encipherText;
    }

    public byte[] Decrypt(byte[] encipherText){
        byte[] sourceText = makeAes(encipherText, Cipher.DECRYPT_MODE);
        return sourceText;
    }

    public byte[] makeAes(byte[] rawMessage, int cipherMode){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, this.secretKey);
            byte [] output = cipher.doFinal(rawMessage);
            return output;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}