/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Inputter {
     public Scanner sc;

    public Inputter() {
        sc = new Scanner(System.in);
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
    
    public String inputString(String prompt) {
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    return sc.nextLine();
    }
    
    
}
