/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {

    private static final String PASSWORD_VALID = "^[a-zA-Z0-9]{8,31}$";
    private static final String ACCOUNT_VALID = "^[0-9]+$";

    private static Scanner sc = new Scanner(System.in);

    private static ResourceBundle bundle;

    public Validation(ResourceBundle bundle) {
        this.bundle = bundle;
    }

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

    public String checkAccountNumber(String accountNumberPrompt) {
        String account = null;
        boolean isValid;
        do {
            isValid = true;
            System.out.println(accountNumberPrompt);
            account = sc.nextLine().trim();
            if (!account.matches(ACCOUNT_VALID)) {
                System.err.println("Acount number have to be number");
                isValid = false;
            } else if (account.length() != 10) {
                System.err.println(bundle.getString("accountNumberInvalid"));
                isValid = false;
            }
        } while (!isValid);
        return account;
    }

    public String checkPassword(String passwordPrompt) {
        String validPassword = null;
        boolean isValid;
        do {
            isValid = true;
            System.out.println(passwordPrompt);
            validPassword = sc.nextLine().trim();
            if (!validPassword.matches(PASSWORD_VALID)) {
                System.err.println(bundle.getString("passwordInvalid"));
                isValid = false;
            }
        } while (!isValid);
        return validPassword;
    }

    public String checkCaptcha(String captchaPrompt, String captchaGenerated) {
        while (true) {
            System.out.println(captchaPrompt);
            String captchaInput = sc.nextLine().trim();
            if (captchaGenerated.contains(captchaInput)) {
                return captchaInput;
            } else {
                System.err.println(bundle.getString("captchaIncorrect"));
            }
        }
    }
}
