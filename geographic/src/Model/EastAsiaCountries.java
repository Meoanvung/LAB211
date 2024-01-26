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
public class EastAsiaCountries extends country implements Comparable<EastAsiaCountries> {

    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display(ArrayList<country> list_c) {
        if (list_c.isEmpty()) {
            System.out.println("The list country is empty, please add information first");
        } else {
            System.out.printf("| %-10s | %-10s | %-13s | %-10s%n", "Code", "Name", "Total Area", "Terrain");
            System.out.println("=====================================================");

            for (country co : list_c) {
                if (co instanceof EastAsiaCountries) {
                    //kiểm tra nếu đối tượng co là một instance của EastAsiaCountries, thì chúng ta chuyển đổi nó thành EastAsiaCountries và sử dụng các phương thức và thuộc tính của nó, bao gồm getCountryTerrain()
                    EastAsiaCountries eastAsiaCo = (EastAsiaCountries) co;
                    System.out.printf("| %-10s | %-10s | %-13s | %-10s%n",
                            eastAsiaCo.getCountryCode(), eastAsiaCo.getCountryName(),
                            eastAsiaCo.getTotalArea() + "km2", eastAsiaCo.getCountryTerrain());
                } else {
                    System.out.println("Invalid type of country");
                }
            }
        }
    }

    @Override
    public int compareTo(EastAsiaCountries o) {
        return this.getCountryName().compareTo(o.getCountryName());
    }

}
