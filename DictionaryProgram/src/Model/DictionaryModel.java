/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.HashMap;

public class DictionaryModel {

    private HashMap<String, String> dic;

    public DictionaryModel() {
        dic = new HashMap<>();
    }

    public HashMap<String, String> getDictionary() {
        return dic;
    }

    public void setDictionary(HashMap<String, String> dic) {
        this.dic = dic;
    }

}

