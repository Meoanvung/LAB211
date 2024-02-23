/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import Utils.Function;
import View.Menu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.DictionaryModel;

/**
 *
 * @author DELL
 */
public class dictionary extends Menu{
    DictionaryModel dic;
    Function f;
    Inputter input;

    public dictionary() throws IOException {
        super("----------- Dictionary Programmer -----------", new String[]{"Add new word", "Delete word", "Translate word", "Exit"});
        input = new Inputter();
        f = new Function(input);
        dic = new DictionaryModel();

    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
            {
                try {
                    f.addWord();
                } catch (IOException ex) {
                    Logger.getLogger(dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            case 2 ->
            {
                try {
                    f.deleteWord();
                } catch (IOException ex) {
                    Logger.getLogger(dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 3 ->
            {
                try {
                    f.TranslateWord();
                } catch (IOException ex) {
                    Logger.getLogger(dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 4 ->
                System.exit(0);
        }
    }
}