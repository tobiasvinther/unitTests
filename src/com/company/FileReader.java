package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public boolean checkIfUserExists(String cpr, String password) throws FileNotFoundException {
        File userBase = new File("resources/userbase.txt");
        Scanner fileScanner= new Scanner(userBase);

        fileScanner.nextLine();

        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] linesAsArray = line.split(";"); //crate array of Strings, using semicolon as separator
            //if index 0 (which is cpr) is the same as the parameter "cpr", then the user exists
            if(linesAsArray[0].equals(cpr)) {
                System.out.println("Success - user found in database");
                return true;
            }
        }
        //if not, the user doesn't exist and therefore we throw an exception
        throw new NoSuchUserException();
    }
}
