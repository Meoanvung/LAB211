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
        double result = 0; // Khởi tạo result để lưu kết quả tính toán liên tục
        boolean tiepTucTinhToan = true;
        boolean firstO = true;
        double second;
        double first = 0;
        while (tiepTucTinhToan) {
            if (firstO) {
                first = input.getDoubleFromInput("Enter number: ");
            }
            String operatorStr = checkOperator();

            if (operatorStr.equals("=")) {
                // Nếu "=" được nhập, tính kết quả cuối cùng và in ra
                System.out.println("Result: " + result);
                tiepTucTinhToan = false;
            } else {
                do {
                    second = input.getDoubleFromInput("Enter number: ");

                    if (operatorStr.equalsIgnoreCase("/") && second == 0) {
                        System.out.println("Error! Divison by zero, please enter again");
                    }
                } while (operatorStr.equalsIgnoreCase("/") && second == 0);
                // Chuyển đổi operatorStr sang Enum Operator
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
                        System.out.println("Toán tử không hợp lệ");
                        return;
                }

                // Tạo đối tượng Caculator sử dụng kết quả tính toán liên tục
                // Gọi phương thức calculate để thực hiện tính toán
                if (firstO) {
                    Caculator cau = new Caculator(first, second, memory, operator);
                    // Gọi phương thức calculate để thực hiện tính toán
                    result = cau.calculate(first, operator, second);

                    memory = result;
                    firstO = false;
                } else {
                    Caculator ca = new Caculator(result, second, memory, operator);
                    result = ca.calculate(result, operator, second);

                    // Lưu kết quả vào bộ nhớ, kiểm tra NaN
                    memory = result;

                }
                // In kết quả liên tục và yêu cầu toán tử tiếp theo
                System.out.println("Memory: " + memory);
            }
        }
    }

    public void CalculateBMI() {
        double weight = input.getDoubleFromInput("Enter your weight(kg): ");
        double height = input.getDoubleFromInput("Enter your height(cm): ");

        // tạo đối tượng
        BMI b = new BMI(height / 100, weight, 0, null);

        // gọi hàm calculateBMI từ class Model
        b.calculateBMI();

        System.out.println("BMI Number:" + String.format("%.2f", b.getBMI()));
        System.out.println("BMI Status: " + b.getBMIStatus());

    }

}
