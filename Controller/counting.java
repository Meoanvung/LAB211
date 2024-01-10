/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Data;
import View.Menu;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class counting extends Menu {

    Data data = new Data();
    String str;

    public counting() {
        super("Couting Management", Arrays.asList(new String[]{"Input a String ", "Count the letters", "Count the characters", "Exit"}));
    }

    public void letterCount(String str) {
        String[] words = str.split("\\s+");
        Map<String, Integer> dictionary = new HashMap<>();

        for (String word : words) {
            dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
        }
        boolean isFirst = true;
        System.out.print("{");
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            if (!isFirst) {
                System.out.print(", ");
            } else {
                isFirst = false;
            }
            System.out.print(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("}");
    }

    public void charCount(String str) {
        int letterCount = 0, digitCount = 0, wordCount = 0;
        Map<Character, Integer> letterFrequency = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                letterCount++;
                ch = Character.toLowerCase(ch);
                letterFrequency.put(ch, letterFrequency.getOrDefault(ch, 0) + 1);
            } else if (Character.isDigit(ch)) {
                digitCount++;
            }
        }

        System.out.print("{");
        for (Map.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
            System.out.print(entry.getKey() + " = " + entry.getValue() + ", ");
        }
        System.out.println("}");
        System.out.println("So ky tu: " + letterCount);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                str = data.getInputString("Enter your string: ");
                break;
            case 2:
                letterCount(str);
                break;
            case 3:
                charCount(str);
                break;
            case 4:
                System.err.println("Exited. Bye bye");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }

}
