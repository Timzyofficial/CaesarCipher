package org.example.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EncodingTest {

    @Test
    public void testEncoding() {
        String originalText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String encodedTextExpected = "WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ";
        int key = 3;
        Encoding encoding = new Encoding(key, originalText);
        String encodedText = encoding.getOutput();

        Assertions.assertEquals(encodedTextExpected, encodedText);
    }

    @Test
    public void testEncodingInvalidInput() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Encoding(3, "TestInvalid23").getOutput();
        });

        String expectedMessage = "The input provided contains characters out of alphabet";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}
