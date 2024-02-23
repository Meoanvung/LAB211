/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.DictionaryModel;
import Controller.dictionary;
import Common.Inputter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class Function {

    private DictionaryModel dictionaryModel;
    private Map<String, String> dic = new HashMap<>();
    Inputter input;

    public Function() {
        dictionaryModel = new DictionaryModel();
    }

    public Function(Inputter input) {
        this();
        this.input = input;
    }
    
    /*
    public void display() {
        Map<String, String> dic = dictionaryModel.getDictionary();
        for (Map.Entry<String, String> entry : dic.entrySet()) {
            String eng = entry.getKey();
            String vi = entry.getValue();
            System.out.println(eng + " - " + vi);
        }
    }*/
    
    public void display() {
        for (Map.Entry<String, String> entry : dictionaryModel.getDictionary().entrySet()) {
            String eng = entry.getKey();
            String vi = entry.getValue();
            System.out.println(eng + " - " + vi);
        }
    }

    public void loadData() throws IOException {
        File f = new File("Dictionary.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] words = line.split("[-]");
            String eng = words[0].trim(), vi = words[1].trim();
            dic.put(eng, vi);
        }

        br.close();
        fr.close();
    }

    public void saveData() throws IOException {
        File f = new File("Dictionary.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<String, String> entry : dic.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue());
            bw.write("\n");
        }

        bw.close();
        fw.close();
    }

    public void addWord() throws IOException {
        System.out.println("------ADD------");
        String eng = input.getStringFromInput("Enter english word: ");
        if (dic.containsKey(eng) && !input.getYN(eng + " is already existed in dictionary! Do you want to update meaning? ")) {
            return;
        }

        String vi = input.getStringFromInput("enter vietnamese: ");
        dic.put(eng, vi);
        saveData();
        System.out.println("add successfull!");
    }

    public boolean deleteWord() throws IOException {
        System.out.println("------DELETE------");
        String eng = input.getStringFromInput("Enter english word to delete: ");
        if (!dic.containsKey(eng)) {
            System.err.println("WORD NOT FOUND!");
        }
        dic.remove(eng);
        saveData();
        System.out.println("Delete successfull!");
        return true;
    }

    public String TranslateWord() throws IOException {
        System.out.println("------TRANSLATE------");
        String eng = input.getStringFromInput("Enter english word to translate: ");
        if (!dic.containsKey(eng)) {
            System.err.println("Word not exist in dictionary!");
        }

        System.out.println("VietNamese: " + dic.get(eng));
        return null;
    }

}
