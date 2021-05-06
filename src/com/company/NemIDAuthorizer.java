package com.company;

import java.util.InputMismatchException;

public class NemIDAuthorizer {

    public boolean checkCprValidity(String cpr) {
        //If cpr does not adhere to a valid cpr number - it will throw a new Input-MismatchException
        //If InputMismatchException is thrown - the program will inform the user and request another input

            if(cpr.length() != 10) {
                throw new InputMismatchException();
            } else if(cpr.matches(".*[a-zA-Z]+.*")) {
                throw new InputMismatchException();
            } else {
                System.out.println("CPR accepted");
                return true;
            }
    }

    /**
     * @param password
     * @param cpr
     * @return
     */
    public boolean checkPasswordValidity(String password, String cpr) {
        //Skal være mellem 6 og 40 tegn -
        //Skal indeholde både bogstaver og tal -
        //Må ikke indeholde visse specialtegn, herunder æ, ø og å -
        //Må ikke indeholde det samme tegn 4 gange i træk
        //Må hverken starte eller slutte med et blanktegn
        //Må ikke indeholde dit cpr- eller NemID-nummer
        //Der skelnes ikke mellem store og små bogstaver. Tilladte specialtegn er: { } ! # " $ ’ % ^ & , * ( ) _ + - = : ; ? . og @.

        if(password.length() < 6 || password.length() > 40) {
            throw new IllegalPasswordException("Password must be between 6 and 40 characters");
        } else if(!password.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalPasswordException("Password must contain at least one letter");
        } else if(!password.matches(".*[0-9]+.*") ) {
            throw new IllegalPasswordException("Password must contain at least one number");
        } else if(password.matches(".*[æøå]+.*")) {
            throw new IllegalPasswordException("Password can't contain æ, ø, or å");
        } else if(checkRepeatingChars(password)) {
            throw new IllegalPasswordException("Password cannot contain the same character 4 times in a row");
        } else if(password.contains(" ")) {
            throw new IllegalPasswordException("Password can't contain white space");
        } else if(password.contains(cpr)) {
            throw new IllegalPasswordException("Password can't contain your CPR");
        } else if(password.matches(".*[£¤/|¨]+.*")) { //todo: add the rest of the illegal symbols
            throw new IllegalPasswordException("Password can't contain £, ¤, /, |, or ¨");
        }else {
            System.out.println("Password is valid");
            return true;
        }
    }

    public boolean checkRepeatingChars(String password) {
        char[] charArray = password.toCharArray();
        for(int i=3; i<charArray.length; i++){
            if(charArray[i] == charArray[i-1] && charArray[i] == charArray[i-2] && charArray[i] == charArray[i-3]) {
                return true;
            }
        }
        return false;
    }
}