/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BMI.BMIstatus;
import Model.Caculator.Operator;
import Common.Inputter;
import View.Menu;
import Model.Caculator;
import Model.BMI;

/**
 *
 * @author DELL
 */
public class ComputerController extends Menu {

    public double memory;

    static String[] choice = {"Normal caculator", "BMI caculator", "Exit"};
    Inputter input;

    public ComputerController() {
        super("MENU", choice);
        input = new Inputter();
        memory = 0;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                normalCaculator();
                break;
            case 2:
                CalculateBMI();
                break;
            case 3:
                System.exit(0);

        }

    }

    public String checkOperator() {
        while (true) {
            String str = input.getStringFromInput("Enter operator: ");
            if (str.isEmpty()) {
                System.out.println("The operator is emty");
            } else if (str.equalsIgnoreCase("=") || str.equalsIgnoreCase("+") || str.equalsIgnoreCase("-") || str.equalsIgnoreCase("*") || str.equalsIgnoreCase("/") || str.equalsIgnoreCase("^")) {
                return str;
            } else {
                System.out.println("Please input one of operator(+,-,*,/,^");
            }
            System.out.println("please try again: ");
        }
    }

    public void normalCaculator() {
        double first = input.getDoubleFromInput("Enter the first Number: ");
        String operatorStr = checkOperator();
        double second = input.getDoubleFromInput("Enter the second number: ");

        //chuyển đổi operatorStr thành enum operator
        Operator operator;
        switch (operatorStr) {
            case "+":
                operator = Operator.ADDITION;
                break;
            case "-":
                operator = Operator.SUBTRACTION;
                break;
            case "*":
                operator = Operator.MULTIPLICATION;
                break;
            case "/":
                operator = Operator.DIVISION;
                break;
            case "^":
                operator = Operator.EXPONENTIATION;
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        // tạo đối tượng ca từ dữ liệu nhập vào
        Caculator ca = new Caculator(first, second, memory, operator);
        //gọi hàm caculate để tính
        double result = ca.calculate(first, operator, second);
        if (operatorStr.equals("=")) {
            // In kết quả lấy từ memory
            System.out.println("Result: " + memory);
        } else {
            // Lưu kết quả vào memory
            memory = result;
            System.out.println("Memory: " + memory);
        }

    }

    public void CalculateBMI() {
        double weight = input.getDoubleFromInput("Enter your weight(kg): ");
        double height = input.getDoubleFromInput("Enter your height(cm): ");

        // tạo đối tượng
        BMI b = new BMI(height / 100, weight, 0, null);

        // gọi hàm calculateBMI từ class Model
        b.calculateBMI();

        System.out.println("BMI Number: " + b.getBMI());
        System.out.println("BMI Status: " + b.getBMIStatus());

    }

}
