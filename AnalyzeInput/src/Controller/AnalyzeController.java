/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.inputString;
import View.viewAnalyzeInput;
import java.util.Scanner;

public class AnalyzeController {

    viewAnalyzeInput view;

    public AnalyzeController() {
        view = new viewAnalyzeInput();
    }

    public void run() {
        inputString f = new inputString();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input string: ");
        f.setStr(scanner.nextLine());
        System.out.println("===== Analysis String program =====");
        view.analyzeInput(f);
    }

}
