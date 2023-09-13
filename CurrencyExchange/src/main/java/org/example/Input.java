package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public int scannerInt() {
        int result = 0;
        while (result == 0) {
            try {
                result = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.err.println("Wrong input! Please enter a number. (1-9)");
                scanner.nextLine();
            }
        }
        return result;
    }

    public BigDecimal scannerNumber() {
        BigDecimal result = new BigDecimal(0);
        while (result.intValue() == 0) {
            try {
                result = scanner.nextBigDecimal();
            } catch (InputMismatchException ime) {
                System.err.println("Wrong input! Please enter a number (if it is decimal, it must be seperated with ','!)");
                scanner.nextLine();
                result = BigDecimal.ZERO;
            }
        }
        return result;
    }

    public void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scanner.nextLine();
    }
}
