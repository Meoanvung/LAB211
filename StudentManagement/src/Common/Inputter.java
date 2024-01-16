/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter {

    public Scanner sc;

    public Inputter() {
        sc = new Scanner(System.in);
    }

    public double getDoubleFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(String.format("Enter %s: ", msg));
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the double number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the double number > 0 ");
                sc.next();
            }
        }
    }

    public int getIntFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number >= 1 && number <= 10) {
                    return number;
                } else {
                    System.err.println("Please enter the semester around 1 to 10: ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just enter the semester >= 1 and <= 10 ");
                sc.next();
            }
        }
    }

    public String getStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("Enter student name: ", msg));
            s = sc.nextLine();
        }
        return s;
    }

    public String inputPattern(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches("[a-zA-Z]+")); // Chỉ chấp nhận chữ cái (viết hoa hoặc viết thường)

        return data;
    }

    public boolean inputYN(String msg) {
        String result = inputPattern(msg);
        return result.equalsIgnoreCase("Y");
    }

    public int inputPositiveInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {//exception về datatype của đầu vào
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter a number from " + m + " to " + n);
            }
        }
        return a;
    }

}
