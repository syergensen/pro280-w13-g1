package model;

import java.text.DecimalFormat;

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
    public Double add(double a, double b){
        return a + b;
    }

    // subtracts a from b
    public Double subtract(double a, double b){
        return a - b;
    }

    // multiplies a with b
    public Double multiply(double a, double b){
        return a * b;
    }

    // divides a by b
    public Double divide(double a, double b){
        return a / b;
    }

    public Double truncate(double a){
        DecimalFormat df = new DecimalFormat("0.##");
        String d = df.format(a);
        Double trunc = new Double(d);
        return trunc.doubleValue();
    }
}
