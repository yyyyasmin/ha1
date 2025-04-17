package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



    //TEILAUFGABE 1

    @Test
    @DisplayName("kehrt das Vorzeichen der Zahl um")
    void testConvertSign(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        //calc.pressNegativeKey();
        calc.pressDigitKey(3);
        calc.pressNegativeKey();

        String expected = "-23";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }



    //TEILAUFGABE 2: erster roter Test


    @Test
    @DisplayName("soll die Berechnung weiterführen, wenn man binaryOperations hinzufügt")
    void testBerechnungWeiterfuehren(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);                  //(2x2 = 4)

        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);                  // (4x3 = 12)
        calc.pressEqualsKey();

        String expected = "12";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



    //TEILAUFGABE 2: zweiter roter Test

    @Test
    @DisplayName("soll die Berechnung wiederholen, wenn in der Konsole = eingegeben wird")
    void testBerechnungWiederholen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();      //(2x2 = 4)
        calc.pressEqualsKey();      //(4x2 = 8)
        calc.pressEqualsKey();      //(8x2 = 16)

        String expected = "16";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }












}

