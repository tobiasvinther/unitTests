package com.company;

public class IllegalPasswordException extends RuntimeException {
    IllegalPasswordException() {
        super("Password must: \n" +
                "Skal være mellem 6 og 40 tegn\n" +
                "Skal indeholde både bogstaver og tal\n" +
                "Må ikke indeholde visse specialtegn, herunder æ, ø og å\n" +
                "Må ikke indeholde det samme tegn 4 gange i træk\n" +
                "Må hverken starte eller slutte med et blanktegn\n" +
                "Må ikke indeholde dit cpr- eller NemID-nummer\n" +
                "Der skelnes ikke mellem store og små bogstaver. Tilladte specialtegn er:\n { } ! # \" $ ’ % ^ & , * ( ) _ + - = : ; ? . og @. ");
    }

    IllegalPasswordException(String message) {
        super(message);

    }

}
