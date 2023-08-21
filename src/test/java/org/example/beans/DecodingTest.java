package org.example.beans;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DecodingTest {

    @Test
    public void testDecoding() {
        String originalText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String encodedText = "WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ";
        int key = 3;
        Decoding decoding = new Decoding(key, encodedText);
        String decodedText = decoding.getOutput();

        Assertions.assertEquals(originalText, decodedText);
    }

    @Test
    public void testDecodingInvalidInput() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Decoding(3, "TestInvalid23").getOutput();
        });

        String expectedMessage = "The input provided contains characters out of alphabet";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testDecodingInvalidKey() {
        String originalText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String encodedText = "WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ";
        int key = 4;//Wrong key
        Decoding decoding = new Decoding(key, encodedText);
        String decodedText = decoding.getOutput();

        Assertions.assertNotEquals(originalText, decodedText);
    }
}
