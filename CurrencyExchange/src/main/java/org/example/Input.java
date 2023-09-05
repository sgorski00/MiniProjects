package org.example;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    public String scannerText(){
        return scanner.nextLine();
    }

    public double scannerNumber(){
        return scanner.nextDouble();
    }

}
