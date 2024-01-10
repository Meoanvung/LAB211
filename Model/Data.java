/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.*;

public class Data {

    private String value;

    public Data() {
    }

    static Scanner sc = new Scanner(System.in);

    public Data(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" + "value=" + value + '}';
    }

    public String getInputString(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(String.format("%s", msg));
            input = sc.nextLine().trim();
            if (input.matches("[a-zA-Z0-9\s]+")) {
                return input;
            } else {
                System.err.println("Just input the string.");
            }
        }
    }

}
