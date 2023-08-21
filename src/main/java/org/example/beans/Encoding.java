package org.example.beans;

public class Encoding {
    private int key ;
    private String input ;
    private String output ;
    public Encoding (int key, String input){
        this.key = key;
        this.input = input ;

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

                int cypherIndex = (indexOnAlphabet + key) % alphabet.length();
                char cypherChar = alphabet.charAt(cypherIndex);
                output = output + cypherChar;
            }
        }
        return output;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
