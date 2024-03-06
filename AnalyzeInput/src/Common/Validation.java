/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import Model.inputString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Validation { 
    
    public String getStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("Enter student name: ", msg));
            s = sc.nextLine();
        }
        return s;
    }
    
    public boolean checkSquareNumber(int n) {
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            return true;
        }
        return false;
    }

    public void getNumber(inputString inputString) {
        HashMap<String, ArrayList<Integer>> HMNumber = new HashMap<>();
        String number = getNumberCharacter(inputString.getStr());
        String[] listNumber = number.split(",");
        int lenNumber = listNumber.length;
        ArrayList<Integer> liPerfectSquare = new ArrayList<>();
        ArrayList<Integer> liOdd = new ArrayList<>();
        ArrayList<Integer> liEven = new ArrayList<>();
        ArrayList<Integer> liAll = new ArrayList<>();

        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1) {
                liOdd.add(numberCheck);
            }
            if (numberCheck % 2 == 0) {
                liEven.add(numberCheck);
            }

            if (checkSquareNumber(numberCheck)) {
                liPerfectSquare.add(numberCheck);
            }

            liAll.add(numberCheck);
        }
        HMNumber.put("Perfect square number: ", liPerfectSquare);
        HMNumber.put("Even number: ", liEven);
        HMNumber.put("Odd number: ", liOdd);
        HMNumber.put("All number: ", liAll);

        for (Map.Entry m : HMNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }

    public String getNumberCharacter(String inputString) {
        String number = inputString.replaceAll("\\D+", ",");
        return number;
    }
 
    public void getCharacter(inputString inputString) {//mđ:lấy string từ model 
        HashMap<String, String> HMString = new HashMap<>();
        HMString.put("Uppercase: ", getUpperChar(inputString.getStr()));
        HMString.put("Lowercase: ", getLowerChar(inputString.getStr()));
        HMString.put("Special: ", getSpecialChar(inputString.getStr()));
        HMString.put("All Characyter: ", getAllChar(inputString.getStr()));

        for (Map.Entry m : HMString.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }

    public String getAllChar(String inputString) { // lấy string từ cái getCharacter
        String allChar = inputString.replaceAll("[0-9]", "");
        return allChar;
    }

    public String getUpperChar(String inputString) {
        String uppercase = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
        return uppercase;
    }

    public String getLowerChar(String inputString) {
        String lowercase = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
        return lowercase;
    }

    public String getSpecialChar(String inputString) {
        String special = inputString.replaceAll("\\w", "");
        return special;
    }

}
