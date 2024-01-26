/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class country {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public country(){
    } 

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    
    public void display(ArrayList<country> list_c){
    }
    
}
