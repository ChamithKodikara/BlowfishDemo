package com.vgates.sample.blowfish.demo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author chamith
 */
public class NumberMaskTester {
    @Test
    public void shouldReturnEncryptedValueWhenOriginalValueAndPasswordGiven() {
        String originalVal = "0012385485256268";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        String maskedCCNumber = encryptor.maskCCNumber();
        assertThat(maskedCCNumber, is("XXXXXXXXXXXX6268"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOriginalValueIsNull() {
        String originalVal = null;
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.maskCCNumber();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOriginalValueIsEmpty() {
        String originalVal = "";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.maskCCNumber();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOriginalValueLengthNotEqual_16() {
        String originalVal = "";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        encryptor.maskCCNumber();
    }
}
