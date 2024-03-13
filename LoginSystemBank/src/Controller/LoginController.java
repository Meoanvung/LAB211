/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.library;
import Model.Login;
import View.Menu;
import View.ViewLogin;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class LoginController extends Menu {

    Scanner scanner = new Scanner(System.in);

    private static ResourceBundle bundle;
    private ViewLogin view;
    private library input;
    private Login l;

    public LoginController() throws IOException {
        super("-------Login Program-------", new String[]{"Vietnamese", "English", "Exit"});
        input = new library();
        this.l = new Login();
        view = new ViewLogin(new library(), l);
    }

    public static void changeLanguage(Locale locale) {   
        Locale.setDefault(locale);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                changeLanguage(new Locale("vi", "VN"));
                 view.displayLogin(view.loginProgram());
                break;
            case 2:
                changeLanguage(new Locale("en", "US"));
                 view.displayLogin(view.loginProgram());
                break;
            case 3:
                System.out.println("Đã thoát chương trình.");
                scanner.close();
                return;
            default:
                System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
                break;
        }
    }

}
