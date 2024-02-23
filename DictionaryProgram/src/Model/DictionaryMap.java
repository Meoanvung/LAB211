/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Utils.Function;

/**
 *
 * @author DELL
 */
public class DictionaryMap {

    Function f;

    private Map<String, String> dic;

    public DictionaryMap(Function f) throws IOException {
        this.f = f;
        dic = new HashMap<>();
        f.loadData();
        System.out.println(dic);
    }

    public Map<String, String> getdic() {
        return dic;
    }
}
