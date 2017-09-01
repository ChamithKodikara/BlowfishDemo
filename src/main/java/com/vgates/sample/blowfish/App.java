package com.vgates.sample.blowfish;


import com.vgates.sample.blowfish.demo.BlowfishEncryptDecryptorUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author chamith
 */
public class App {

    public static void main(String[] args) {
        encryptSample();
        decryptSample();
    }

    private static void encryptSample() {
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal("Chamith");
        encryptor.setPassword("1qaz@WSX");

        try {
            System.out.println("ENCRYPT 1------------ " + encryptor.encrypt());
        } catch (IllegalArgumentException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            encryptor.setOriginalVal(null);
            System.out.println("ENCRYPT 2------------ " + encryptor.encrypt());
        } catch (IllegalArgumentException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            encryptor.setOriginalVal("");
            System.out.println("ENCRYPT 3------------ " + encryptor.encrypt());
        } catch (IllegalArgumentException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            encryptor.setOriginalVal("Chamith");
            encryptor.setPassword(null);
            System.out.println("ENCRYPT 4------------ " + encryptor.encrypt());
        } catch (IllegalArgumentException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            encryptor.setOriginalVal("Chamith");
            encryptor.setPassword("");
            System.out.println("ENCRYPT 5------------ " + encryptor.encrypt());
        } catch (IllegalArgumentException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void decryptSample() {
        BlowfishEncryptDecryptorUtil decryptor = new BlowfishEncryptDecryptorUtil();
        decryptor.setEncryptVal("S1Ox+LT4++c=");
        decryptor.setPassword("1qaz@WSX");

        try {
            System.out.println("DECRYPT 1------------ " + decryptor.decrypt());
        } catch (IllegalArgumentException | IOException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            decryptor.setEncryptVal(null);
            System.out.println("DECRYPT 2------------ " + decryptor.decrypt());
        }  catch (IllegalArgumentException | IOException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            decryptor.setEncryptVal("");
            System.out.println("DECRYPT 3------------ " + decryptor.decrypt());
        }  catch (IllegalArgumentException | IOException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            decryptor.setEncryptVal("S1Ox+LT4++c=");
            decryptor.setPassword(null);
            System.out.println("DECRYPT 4------------ " + decryptor.decrypt());
        } catch (IllegalArgumentException | IOException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            decryptor.setEncryptVal("S1Ox+LT4++c=");
            decryptor.setPassword("");
            System.out.println("DECRYPT 5------------ " + decryptor.decrypt());
        }  catch (IllegalArgumentException | IOException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            decryptor.setEncryptVal("S1Ox+LT4++c=");
            decryptor.setPassword("1qazXSW@");
            System.out.println("DECRYPT 6------------ " + decryptor.decrypt());
        }  catch (IllegalArgumentException | IOException | NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IllegalBlockSizeException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
