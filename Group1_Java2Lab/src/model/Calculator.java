package model;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/5/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
// This class used to make small calculations such as addition, subtraction, multiplication and division
public class Calculator {

    // adds a to b
    public Integer add(int a, int b){
        return a + b;
    }

    // subtracts a from b
    public Integer subtract(int a, int b){
        return a - b;
    }

    // multiplies a with b
    public Integer multiply(int a, int b){
        return a * b;
    }

    // divides a by b
    public Integer divide(int a, int b){
        return a / b;
    }
}
