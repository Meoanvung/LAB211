/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Locale;
import java.util.ResourceBundle;

public class Login {

    private ResourceBundle resourceBundle;

    @Override
    public String toString() {
        return "Login{" + "accountNumber=" + accountNumber + ", password=" + password + ", captchaInput=" + captchaInput + '}';
    }


    private String accountNumber;
    private String password;
    private String captchaInput;

    
    public Login() {
    this.accountNumber = "";
    this.password = "";
    this.captchaInput = "";
}
   

    public Login(String accountNumber, String password, String captchaInput) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.captchaInput = captchaInput;
    }

    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptchaInput() {
        return captchaInput;
    }

    public void setCaptchaInput(String captchaInput) {
        this.captchaInput = captchaInput;
    }
}