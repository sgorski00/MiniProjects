package org.example;

public class NumberValidator {
    public static boolean doesContainsNumber(String word){
        for(char c : word.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInRange(double number, double min, double max){
        return number >= min && number <= max;
    }
}
