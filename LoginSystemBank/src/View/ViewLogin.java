/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.Validation;
import Common.library;
import Model.Login;
import java.util.Enumeration;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ViewLogin {

    private StringBuilder alphanumeric;
    private Login l;
    private library input;
    private Validation v;
    private ResourceBundle bundle;

    public ViewLogin(library input, Login l) {
        this.input = input;
        this.l = l;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphanumeric = new StringBuilder(alphabet);
        alphanumeric.append("0123456789");
        alphanumeric.append(alphabet.toUpperCase());

    }

    public void setResourceBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public Login loginProgram() {
        ResourceBundle bundle = ResourceBundle.getBundle("Language");
        v = new Validation(bundle);
        
        String accountNumberPrompt = bundle.getString("accountNumberPrompt");
        String accountNumber = v.checkAccountNumber(accountNumberPrompt);

        String passwordPrompt = bundle.getString("passwordPrompt");
        String password = v.checkPassword(passwordPrompt);

        String captchaGenerated = randomString(6);
        System.out.println(bundle.getString("captchaGenerate") + captchaGenerated);
        String captchaPrompt = bundle.getString("captchaPrompt");
        String captchaInput = v.checkCaptcha(captchaPrompt, captchaGenerated);

        setResourceBundle(bundle);

        return new Login(accountNumber, password, captchaInput);
         
    }
    
    public void displayLogin(Login login){
        System.out.println(login.toString());
    }

    public String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphanumeric.length());
            sb.append(alphanumeric.charAt(index));
        }
        return sb.toString();
    }
        public void displayPro() {
        ResourceBundle bun = ResourceBundle.getBundle("Language");
        Enumeration<String> keys = bun.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = bun.getString(key);
            System.out.println(key + ": " + value);
        }
    }
}
