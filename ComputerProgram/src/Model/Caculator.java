/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Caculator {

    public double first;
    public double second;
    public double result;
    public Operator operator;

    public Caculator(double first, double second, double result, Operator operator) {
        this.first = first;
        this.second = second;
        this.result = result;
        this.operator = operator;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public double getResult() {
        return result;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    //Enum là một kiểu dữ liệu đặc biệt cho phép một biến có thể là một tập hợp các hằng số định sẵn. 
    // đại diện cho các toán tử (+,-,*,/,^)
    public enum Operator {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        EXPONENTIATION
    }
     
    public double calculate(double a, Operator operator, double b) {
        double result = 0;
        switch (operator) {
            case ADDITION:
                result = first + second;
                break;
            case SUBTRACTION:
                result = first - second;
                break;
            case MULTIPLICATION:
                result = first * second;
                break;
            case DIVISION:
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            case EXPONENTIATION:
                result = Math.pow(first, second);
                break;
        }
        this.result = result;
        return result;
    }
}
