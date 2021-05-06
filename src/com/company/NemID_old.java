package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NemID_old {

    public boolean isValidInput (String cpr, String password) {
        //If cpr does not adhere to a valid cpr number - it will throw a new Input-MismatchException
        //If InputMismatchException is thrown - the program will inform the user and request another input

        try {
            if(cpr.length() != 10) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Try again");
            Scanner userInput = new Scanner(System.in);
            String newCpr = userInput.nextLine();
            isValidInput(newCpr, password);
        }

        System.out.println("CPR accepted");
        return true;
    }

}
