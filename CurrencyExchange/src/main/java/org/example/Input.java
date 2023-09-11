package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);
    public String scannerText(){
        return scanner.nextLine();
    }

    public double scannerNumber(){
        return scanner.nextDouble();
    }

    public void pressEnterToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scanner.nextLine();
    }
}
