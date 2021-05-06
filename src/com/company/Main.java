package com.company;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        NemIDAuthorizer nem = new NemIDAuthorizer();
        Scanner userInput = new Scanner (System.in);
        FileReader fileReader = new FileReader();

        //testing passwordValidator
        nem.checkPasswordValidity("Flintstone1", "1234567890");

        //testing NemIDAuthorizer and try/catch
        while(true) {
            System.out.println("Input CPR to check if it is the valid format (10 digits):");
            String cpr = userInput.nextLine();

            try {
                nem.checkCprValidity(cpr);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Wrong CPR length, try again");
            }
        }

        //testing FileReader and the custom exception NoSuchUserExists
        System.out.println("Input CPR to check if user exists in the database:");
        String cpr = userInput.nextLine();
        fileReader.checkIfUserExists(cpr, "testpassword");

        /*
        while(true) {
            System.out.println("Input CPR to check if user exists in the database:");
            String cpr = userInput.nextLine();
            try {
                fileReader.checkIfUserExists(cpr, "testpassword");
                break;
            } catch (NoSuchUserException e) {
                e.getMessage();
            }
        }
         */




    }
}
