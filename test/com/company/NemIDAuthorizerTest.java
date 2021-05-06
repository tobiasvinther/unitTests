package com.company;

import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;
import static org.junit.jupiter.api.Assertions.*;

class NemIDAuthorizerTest {

    @Test
    void checkCprValidity() {
        //ARRANGE
        NemIDAuthorizer nemIDTest = new NemIDAuthorizer();

        //ACT
        boolean legalCPR = nemIDTest.checkCprValidity("1234567890");
        boolean legalPassword = nemIDTest.checkPasswordValidity("FlintStone1", "1234567890");
        boolean legalPassword2 = nemIDTest.checkPasswordValidity("12&Mevooo", "1234567890");

        //ASSERT
        //legal CPR and passwords
        assertTrue(legalCPR);
        assertTrue(legalPassword);
        assertTrue(legalPassword2);
        //exceptions:
        //password too short
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("g5y", "1234567890"));
        //password too short (borderline, 5 chars)
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("g5y!H", "1234567890"));
        //password too long
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("fiefeNfnewo!!87765nfkdsmkfldscmkdsljre83746893gdgfvbD4ggdert6654", "1234567890"));
        //passwords has no numbers
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("Yabbadaboo!", "1234567890"));
        //password is the same as cpr
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("1234567890", "1234567890"));
        //password has no letters
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("947532&&&", "1234567890"));
        //password has four repeating characters
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("FlintStone1111", "1234567890"));
        //password has whitespace
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("Flint Stone1", "1234567890"));
        //password contains æ, æ, or å
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("FlintStone1!æøå", "1234567890"));
        //password contains illegal symbol (e.g. £)
        assertThrows(IllegalPasswordException.class,()->nemIDTest.checkPasswordValidity("FlintStone1!£", "1234567890"));
        //cpr too short
        assertThrows(InputMismatchException.class,()->nemIDTest.checkCprValidity("123"));
        //cpr too short (borderline, 9 numbers)
        assertThrows(InputMismatchException.class,()->nemIDTest.checkCprValidity("123456789"));
        //cpr too long (borderline, 11 numbers)
        assertThrows(InputMismatchException.class,()->nemIDTest.checkCprValidity("12345678900"));
        //cpr is correct length, but not numbers
        assertThrows(InputMismatchException.class,()->nemIDTest.checkCprValidity("abcdefgijk"));
    }
}