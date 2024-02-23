/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.HashMap;
import java.util.Map;

public class DictionaryModel {

    private Map<String, String> dic;

    public DictionaryModel() {
        dic = new HashMap<>();
    }

    public Map<String, String> getDictionary() {
        return dic;
    }

    public void setDictionary(Map<String, String> dic) {
        this.dic = dic;
    }

}

