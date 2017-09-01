package com.vgates.sample.blowfish.demo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author chamith
 */
public class BlowfishEncryptDecryptorUtil {


    private String originalVal;
    private String encryptVal;
    private String password;
    protected byte[] bytes;
    protected final String CREDIT_CARD_NUMBER_MASK;

    public BlowfishEncryptDecryptorUtil() {
        CREDIT_CARD_NUMBER_MASK = "XXXXXXXXXXXX";
    }

    public String encrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException, InvalidKeyException {
        if (originalVal != null && !originalVal.isEmpty() && password != null && !password.isEmpty()) {
            byte[] keyData = (password).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            bytes = cipher.doFinal(originalVal.getBytes());
            return new BASE64Encoder().encode(bytes);
        } else {
            throw new IllegalArgumentException("Invalid Original Value or Password");
        }
    }

    public String decrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException,
            IllegalBlockSizeException {
        if (encryptVal != null && !encryptVal.isEmpty() && password != null && !password.isEmpty()) {
            byte[] keyData = (password).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            try {
                return new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(encryptVal)));
            } catch (BadPaddingException e) {
                throw new IllegalArgumentException("Incorrect Password");
            }
        } else {
            throw new IllegalArgumentException("Invalid Encrypted Value or Password is empty");
        }
    }

    public String maskCCNumber() {
        if (originalVal != null && !originalVal.isEmpty() && originalVal.length() == 16) {
            return CREDIT_CARD_NUMBER_MASK + originalVal.substring(originalVal.length() - 4, originalVal.length());
        } else {
            throw new IllegalArgumentException("Invalid Original Value");
        }
    }

    public String getOriginalVal() {
        return originalVal;
    }

    public void setOriginalVal(String originalVal) {
        this.originalVal = originalVal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEncryptVal() {
        return encryptVal;
    }

    public void setEncryptVal(String encryptVal) {
        this.encryptVal = encryptVal;
    }


}
