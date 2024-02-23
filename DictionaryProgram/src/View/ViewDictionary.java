/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.Library;
import Model.DictionaryModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class ViewDictionary {
    private DictionaryModel dictionaryModel = new DictionaryModel();
    Library input;

    public ViewDictionary() {
        dictionaryModel = new DictionaryModel();
    }

    public ViewDictionary(Library input) {
        this();
        this.input = input;
    }
    
    public void display(HashMap<String, String> dic) {
        for (Map.Entry<String, String> entry : dic.entrySet()) {
            String eng = entry.getKey();
            String vi = entry.getValue();
            System.out.println(eng + " - " + vi);
        }
    }
    
    public void loadData(HashMap<String, String> dic) throws IOException {
    File f = new File("Dictionary.txt");
    if (!f.exists()) {
        throw new FileNotFoundException("File not found: " + f.getAbsolutePath());
    }
    if (!f.canRead()) {
        throw new IOException("File not readable: " + f.getAbsolutePath());
    }

    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);

    try {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            String[] words = line.split("[-]");
            String eng = words[0].trim(), vi = words[1].trim();
            dic.put(eng, vi);
        }
    } finally {
        br.close();
        fr.close();
    }
}


    public void saveData(HashMap<String, String> dic) throws IOException {
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

    public void addWord(HashMap<String, String> dic) throws IOException {
        System.out.println("------ADD------");
        String eng = input.getStringFromInput("Enter english word: ");
        if (dic.containsKey(eng) && !input.getYN(eng + " is already existed in dictionary! Do you want to update meaning? ")) {
            return;
        }

        String vi = input.getStringFromInput("enter vietnamese: ");
        dic.put(eng, vi);
        saveData(dic);
        System.out.println("add successfull!");
    }

    public boolean deleteWord(HashMap<String, String> dic) throws IOException {
        System.out.println("------DELETE------");
        String eng = input.getStringFromInput("Enter english word to delete: ");
        if (!dic.containsKey(eng)) {
            System.err.println("WORD NOT FOUND!");
            return false;
        }
        dic.remove(eng);
        saveData(dic);
        System.out.println("Delete successfull!");
        return true;
    }

    public String TranslateWord(HashMap<String, String> dic) throws IOException {
        System.out.println("------TRANSLATE------");
        String eng = input.getStringFromInput("Enter english word to translate: ");
        if (!dic.containsKey(eng)) {
            System.err.println("Word not exist in dictionary!");
        }

        System.out.println("VietNamese: " + dic.get(eng));
        return null;
    }

}
