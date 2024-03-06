/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.Validation;
import Model.inputString;

public class viewAnalyzeInput {
    Validation v;
    
    public viewAnalyzeInput() {
        v = new Validation();
    }
    public void analyzeInput(inputString inputString) {
        v.getNumber(inputString);
        v.getCharacter(inputString);
    }   
}
