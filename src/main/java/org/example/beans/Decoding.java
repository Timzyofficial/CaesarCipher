package org.example.beans;

public class Decoding{
    private int key;
    private String input;
    private String output;
    public Decoding (int key, String input){
        this.key = key;
        this.input = input ;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public void setInput (String Input ) {
        this.input = input;
    }

    public String getOutput() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        input = input.toUpperCase();
        output = "";

        for(int i =0; i < input.length(); i++){
            char charOfInput = input.charAt(i);
            if(charOfInput == ' ') {
                output+= charOfInput;
            }else {
                int indexOnAlphabet = alphabet.indexOf(charOfInput);
                if(indexOnAlphabet == -1) {
                    throw new IllegalArgumentException("The input provided contains characters out of alphabet");
                }
                int plainIndex = ((indexOnAlphabet - key + alphabet.length()) % alphabet.length());
                char plainChar = alphabet.charAt(plainIndex);
                output = output + plainChar;
            }
        }
        return output;
    }

}
