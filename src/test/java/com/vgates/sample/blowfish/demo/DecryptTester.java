package com.vgates.sample.blowfish.demo;

import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author chamith
 */
public class DecryptTester {

    @Test
    public void shouldReturnEncryptedValueWhenOriginalValueAndPasswordGiven() throws NoSuchPaddingException,
            NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String encryptVal = "efA32WGEztpEXFokWimRbg==";
        String password = "password";
        BlowfishEncryptDecryptorUtil decryptor = new BlowfishEncryptDecryptorUtil();
        decryptor.setEncryptVal(encryptVal);
        decryptor.setPassword(password);
        String decryptVal = decryptor.decrypt();
        assertThat(decryptVal, is("Test Value"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEncryptValueIsNull() throws NoSuchPaddingException,
            NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String encryptVal = null;
        String password = "password";
        BlowfishEncryptDecryptorUtil decryptor = new BlowfishEncryptDecryptorUtil();
        decryptor.setEncryptVal(encryptVal);
        decryptor.setPassword(password);
        decryptor.decrypt();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEncryptValueIsEmpty() throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String encryptVal = "";
        String password = "password";
        BlowfishEncryptDecryptorUtil decryptor = new BlowfishEncryptDecryptorUtil();
        decryptor.setEncryptVal(encryptVal);
        decryptor.setPassword(password);
        decryptor.decrypt();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPasswordIsNull() throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String encryptVal = "efA32WGEztpEXFokWimRbg==";
        String password = null;
        BlowfishEncryptDecryptorUtil decryptor = new BlowfishEncryptDecryptorUtil();
        decryptor.setEncryptVal(encryptVal);
        decryptor.setPassword(password);
        decryptor.decrypt();

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPasswordIsEmpty() throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String encryptVal = "efA32WGEztpEXFokWimRbg==";
        String password = "";
        BlowfishEncryptDecryptorUtil decryptor = new BlowfishEncryptDecryptorUtil();
        decryptor.setEncryptVal(encryptVal);
        decryptor.setPassword(password);
        decryptor.decrypt();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPasswordIsIncorrect() throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String encryptVal = "efA32WGEztpEXFokWimRbg==";
        String password = "!@#";
        BlowfishEncryptDecryptorUtil decryptor = new BlowfishEncryptDecryptorUtil();
        decryptor.setEncryptVal(encryptVal);
        decryptor.setPassword(password);
        decryptor.decrypt();
    }
}
