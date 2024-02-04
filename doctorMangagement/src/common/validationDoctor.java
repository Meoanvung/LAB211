/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.HashMap;
import model.doctor;

/**
 *
 * @author THANH HUYEN
 */
public class validationDoctor {

    public boolean checkExistDoctorByCode(HashMap<String, doctor> hash, String code) {
       return hash.containsKey(code);
    }

    public boolean checkAvailability(int avail) {
        return avail >= 0 && String.valueOf(avail).matches("[\\d]{0,100}+");
    }
}