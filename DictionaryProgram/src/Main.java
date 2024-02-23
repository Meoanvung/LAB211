
import Common.Library;
import Controller.dictionary;
import Model.DictionaryModel;
import View.ViewDictionary;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Library input = new Library();
        ViewDictionary manage = new ViewDictionary(input);
        manage.loadData();
        manage.display();

        dictionary lib = new dictionary();
        lib.run();
    }
}
