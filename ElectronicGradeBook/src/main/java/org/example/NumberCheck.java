package org.example;

public class NumberCheck {
    public static boolean doesContainsNumber(String word){
        for(char c : word.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}
