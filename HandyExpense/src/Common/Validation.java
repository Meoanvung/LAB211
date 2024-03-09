/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {

    private static final String DATE_FORMAT = "yyyy/MM/dd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    private static Scanner sc = new Scanner(System.in);

    public String checkInput(String mess) {
        while (true) {
            System.out.println(mess);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("The input empty!");
            } else {
                return result;
            }
        }
    }

    public String checkDate(String date) {
        while (true) {
            String checkDate = checkInput(date);
            String dateStr = checkDate;
            String dateFormat = "dd/MM/yyyy";
            boolean Valid = ValidDate(dateStr, dateFormat);

            if (Valid) {
                return checkDate;
            } else {
                System.err.println("must be correct format(dd/MM/yyyy)");
            }
        }
    }

    public boolean ValidDate(String dateStr, String dateFormat) {
        SimpleDateFormat n = new SimpleDateFormat(dateFormat);
        n.setLenient(false);
        try {
            Date date = n.parse(dateStr);
            if (!dateStr.equals(n.format(date))) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
