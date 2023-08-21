package org.example;

import org.example.beans.Decoding;
import org.example.beans.Encoding;

public class Main {
    public static void main(String[] args) {
        String inputText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        Encoding encoding = new Encoding(3, inputText);

        String output = encoding.getOutput();
        System.out.println(output);
        Decoding decoding = new Decoding(3, output);

        System.out.println(decoding.getOutput());

    }
}