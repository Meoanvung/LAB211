/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.viewAnalyzeInput;
import java.util.Scanner;

public class AnalyzeController {

    viewAnalyzeInput view;

    public AnalyzeController() {
        view = new viewAnalyzeInput();
    }

    public void run() {
        //String inputString = "321sdhkjDFGH!@#$%^22fdsf3";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input string: ");
        String inputString = scanner.nextLine();
        view.analyzeInput(inputString);
    }

}
