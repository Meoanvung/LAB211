/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Data;
import View.ViewDataFomat;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class DataFomatController {

    ViewDataFomat view;

    public DataFomatController() {
        view = new ViewDataFomat();
    }

    public void run() {
        System.out.println("===== Check data format program =====");
        Data inputData = view.getDataFromInput();
        System.out.println("Phone number: " + inputData.getPhoneNumber());
        System.out.println("Email: " + inputData.getEmail());
        System.out.println("Date: " + inputData.getDate());
    }

}
