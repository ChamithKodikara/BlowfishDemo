package com.vgates.sample.blowfish.demo;

import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author chamith
 */
public class EncryptTester {

    @Test
    public void shouldReturnEncryptedValueWhenOriginalValueAndPasswordGiven() throws IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String originalVal = "Test Value";
        String password = "password";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.setPassword(password);
        String encryptVal = encryptor.encrypt();
        assertThat(encryptVal, is("efA32WGEztpEXFokWimRbg=="));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOriginalValueIsNull() throws IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String originalVal = null;
        String password = "password";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.setPassword(password);
        encryptor.encrypt();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOriginalValueIsEmpty() throws IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String originalVal = "";
        String password = "password";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.setPassword(password);
        encryptor.encrypt();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPasswordIsNull() throws IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String originalVal = "Test Value";
        String password = null;
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.setPassword(password);
        encryptor.encrypt();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPasswordIsEmpty() throws IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String originalVal = "Test Value";
        String password = "";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.setPassword(password);
        encryptor.encrypt();
    }
}
