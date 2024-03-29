/**
* A library of methods that I am using for my test cases.
*
* @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
*/

public class Utils {

    /**
    * The method prints "Fail..." on the standard output if the value
    * of <code>expected</code> is false.
    *
    * @param expected the expected value
    */

    public static void assertTrue(boolean expected) {

        if (! expected) {
            System.out.println("Fail: expected value = false");
        }

    }

    /**
    * The method prints "Fail..." on the standard output if the value
    * of <code>expected</code> is true.
    *
    * @param expected the expected value
    */

    public static void assertFalse(boolean expected) {

        if (expected) {
            System.out.println("Fail: expected value = false");
        }

    }

    /**
    * Success if <code>result</code> and <code>expected</code> are
    * equals, and error message otherwise.
    *
    * @param expected the expected value
    * @param result some result
    */

    public static void assertEquals(int expected, int result) {

        if (result != expected) {
            System.out.println("Fail: expected value = "+expected+", actual value = "+result);
        }

    }

    /**
    * Success if <code>result</code> and <code>expected</code> are
    * equals, it prints an error message otherwise.
    *
    * @param expected the expected value
    * @param result some result
    */

    public static void assertEquals(boolean expected, boolean result) {

        if (result != expected) {
            System.out.println("Fail: expected value = "+expected+", actual value = "+result);
        }

    }

    public static void assertEquals(double expected, double result,double error) {

        if (result != expected) {
            System.out.println("Fail: expected value = "+expected+", actual value = "+result);
        }

    }




}
