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

    private static final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    private static final String PHONE_VALID = "^[0-9]+$";
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

    public String checkPhone(String phone) {
        String phoneNumber = null;
        boolean g;
        do {
            g = true;
            System.out.println(phone);
            phoneNumber = sc.nextLine().trim();
            if (!phoneNumber.matches(PHONE_VALID)) {
                System.err.println("Phone number have to be number");
                g = false;
            } else if (phoneNumber.length() != 10) {
                System.err.println("Phone number must be 10 digits");
                g = false;
            }
        } while (!g);
        return phoneNumber;
    }

    public String checkEmail(String email) {
        while (true) {
            String checkEmail = checkInput(email);
            if (!checkEmail.matches(EMAIL_VALID)) {
                System.err.println("email have to be in correct format!!");
            } else {
                return checkEmail;
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
