
package calculator;

/**
 * Main methods for a calculator.
 * 
 * @author Alex Vasil
 */
public class Calculator {
    
    /**
     * Adds two numbers together.
     * 
     * @param num1 number 1.
     * @param num2 number 2.
     * @return the value of num1 added to num2.
     */
    public static double addition(double num1, double num2) {
        return num1 + num2;
    }
    
    /**
     * Subtracts two numbers together.
     * 
     * @param num1 number 1.
     * @param num2 number 2.
     * @return the value of num1 subtracted to num2.
     */
    public static double subtration(double num1, double num2) {
        return num1 - num2;
    }
    
    /**
     * Multiplies two numbers together.
     * 
     * @param num1 number 1.
     * @param num2 number 2.
     * @return the value of num1 multiplied by num2.
     */
    public static double multiplication(double num1, double num2) {
        return num1 * num2;
    }
    
    /**
     * Divide two numbers.
     * 
     * @param num1 number 1.
     * @param num2 number 2.
     * @return the value of num1 divided by num2.
     */
    public static double division(double num1, double num2) {
        return num1 / num2;
    }
    
    /**
     * 
     * @param angle
     * @return 
     */
    public static double cosine(double angle) {
        return Math.cos(angle);
    }
    
    /**
     * 
     * @param angle
     * @return 
     */
    public static double sin(double angle) {
        return Math.sin(angle);
    }
    
    /**
     * 
     * @param angle
     * @return 
     */
    public static double tangent(double angle) {
        return Math.tan(angle);
    }
}
