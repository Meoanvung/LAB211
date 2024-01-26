/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

/**
 *
 * @author DELL
 */
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter {

    public Scanner sc;

    public Inputter() {
        sc = new Scanner(System.in);
    }

    public float getFloat(String str) {
        System.out.print(str);
        return sc.nextFloat();
    }

    public float inputFloat(String msg) {
        Scanner sc = new Scanner(System.in);
        float number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextFloat();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the total area > 0 ");
                }
            } catch (InputMismatchException e) {//exception về datatype của đầu vào
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }

    public String getStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("%s", msg));
            s = sc.nextLine();
        }
        return s;
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

    public String inputPattern(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches("[a-zA-Z]+")); // Chỉ chấp nhận chữ cái (viết hoa hoặc viết thường)

        return data;
    }

    public char getYN(String msg) {
        char result = 0;
        boolean isValid = false;

        do {
            System.out.print(msg);
            String input = sc.nextLine();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                result = Character.toUpperCase(input.charAt(0));
                isValid = true;
            } else {
                System.err.println("Please enter a single alphabetical character.");
            }
        } while (!isValid);
        return result;

    }
}
