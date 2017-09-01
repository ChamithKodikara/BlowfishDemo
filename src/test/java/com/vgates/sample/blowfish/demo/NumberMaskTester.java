package com.vgates.sample.blowfish.demo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author chamith
 */
public class NumberMaskTester {
    @Test
    public void shouldReturnEncryptedValueWhenOriginalValueAndPasswordGiven()  {
        String originalVal = "0012385485256268";
        BlowfishEncryptDecryptorUtil encryptor = new BlowfishEncryptDecryptorUtil();
        encryptor.setOriginalVal(originalVal);
        String encryptVal = encryptor.maskCCNumber();
        assertThat(encryptVal, is("XXXXXXXXXXXX6268"));
    }
}
