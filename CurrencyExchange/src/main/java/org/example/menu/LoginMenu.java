package org.example.menu;

import org.example.Input;
import org.example.users.LogIn;

public class LoginMenu {
    private final Input scanner = new Input();
    private final ListOfTasks listOfTasks = new ListOfTasks();
    private final LogIn login = new LogIn();

    public void print() {
        int choice;
        boolean isEnded = false;
        do {
            listOfTasks.printLoginMenu();
            choice = scanner.scannerInt();
            switch (choice) {
                case 1 -> {
                    login.logIn();
                    isEnded = true;
                }
                //case 2 -> register
                //case 3 -> change password
                default -> {
                    System.out.println("Enter correct number");
                    break;
                }
            }
        } while (!isEnded);
    }
}
