/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import Model.EastAsiaCountries;
import Model.country;
import View.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DELL
 */
public class ManageEastAsiaCountries extends Menu {

    static String[] choice = {"Input the information of 11 countries in East Asia", "Display the information of country", "Search the information of country by name", "Display the information of countries sorted name in ascending order", "Exit"};
    Inputter input;
    ArrayList<country> list_c;
    country co;

    public ManageEastAsiaCountries() {
        super("MENU", choice);
        input = new Inputter();
        list_c = new ArrayList<>();
        co = new country();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addCountry();
                break;
            case 2:
                EastAsiaCountries ac = new EastAsiaCountries();
                ac.display(list_c);
                break;
            case 3:
                searchByName();
                break;
            case 4:
                sortInformationByAscendingOrder();
                break;
            case 5:
                System.exit(0);

        }
    }

    public void addCountry() {
        String countryName;
        float totalArea;
        String countryTerrain;
        //do{
        String countryCode = input.getStringFromInput("Enter country code: ");
        if (!checkID(list_c, countryCode)) {
            countryName = input.getStringFromInput("Enter country name: ");
            totalArea = input.inputFloat("Enter the total area");
            countryTerrain = input.getStringFromInput("Enter terrain of that country: ");
            list_c.add(new EastAsiaCountries(countryTerrain, countryCode, countryName, totalArea));
            //limit_S++;
        }
        //}
        //while(list_c.size() == 11); {
        if (list_c.size() == 1) {
            System.out.println("Number of countries in the list: " + list_c.size());
        }

        if (list_c.size() == 11) {
            char continueInput = input.getYN("Do you want to continue (Y/N)? ");
            if (Character.toUpperCase(continueInput) != 'Y') {
                return;
            }
        }
    }

    public boolean checkID(ArrayList<country> list, String countryCode) {
        if (list.isEmpty()) {
            return false;
        } else {
            for (country co : list_c) {
                if (co.getCountryCode().equals(countryCode)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void searchByName() {
        if (list_c.isEmpty()) {
            System.err.println("The list is empty! please add country first to find");
            return;
        }
        ArrayList<country> FindByName = FindByName(list_c);
        if (FindByName.isEmpty()) {
            System.err.println("the country not exist! please check again");
        } else {
            displayFind(FindByName);
        }
    }

    public void displayFind(ArrayList<country> FindByName) {
        System.out.printf("| %-10s | %-10s | %-13s | %-10s%n", "Code", "Name", "Total Area", "Terrain");
        System.out.println("=====================================================");

        for (country co : FindByName) {
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

    public ArrayList<country> FindByName(ArrayList<country> list_c) {
        ArrayList<country> foundCountry = new ArrayList<country>();
        String countryName = input.getStringFromInput("Enter country name to find: ");
        for (country co : list_c) {
            if (co.getCountryName().equalsIgnoreCase(countryName)) {
                foundCountry.add(co);
            }
        }
        return foundCountry;
    }

    public void sortInformationByAscendingOrder() {
        if (list_c.isEmpty()) {
            System.out.println("Danh sách trống. Không có gì để sắp xếp.");
        } else {
            boolean allEastAsiaCountries = list_c.stream().allMatch(c -> c instanceof EastAsiaCountries);
            if (allEastAsiaCountries) {
                Collections.sort(list_c, Comparator.comparing(country::getCountryName));
                System.out.println("Danh sách được sắp xếp theo thứ tự tăng dần theo tên quốc gia.");
                displaySort(list_c);
            } else {
                System.out.println("Loại quốc gia không hợp lệ để sắp xếp.");
            }
        }
    }

    public void displaySort(ArrayList<? extends country> list_c) {
        System.out.printf("| %-10s | %-10s | %-13s | %-10s%n", "Code", "Name", "Total Area", "Terrain");
        System.out.println("=====================================================");

        for (country co : list_c) {
            if (co instanceof EastAsiaCountries) {
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
