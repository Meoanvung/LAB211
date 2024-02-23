/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Library;
import View.Menu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.DictionaryModel;
import View.ViewDictionary;

/**
 *
 * @author DELL
 */
public class dictionary extends Menu{
    DictionaryModel dic;
    ViewDictionary f;
    Library input;

    public dictionary() throws IOException {
        super("----------- Dictionary Programmer -----------", new String[]{"Add new word", "Delete word", "Translate word", "Exit"});
        input = new Library();
        f = new ViewDictionary(input);
        dic = new DictionaryModel();

    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
            {
                try {
                    f.loadData(dic.getDictionary());
                    f.addWord(dic.getDictionary());
                    f.display(dic.getDictionary());
                } catch (IOException ex) {
                    Logger.getLogger(dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            case 2 ->
            {
                try {
                    f.deleteWord(dic.getDictionary());
                } catch (IOException ex) {
                    Logger.getLogger(dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 3 ->
            {
                try {
                    f.TranslateWord(dic.getDictionary());
                } catch (IOException ex) {
                    Logger.getLogger(dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 4 ->
                System.exit(0);
        }
    }
}
