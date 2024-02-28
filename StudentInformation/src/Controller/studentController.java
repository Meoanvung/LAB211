/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.library;
import Model.Student;
import View.Menu;
import View.ViewStudent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class studentController extends Menu {
    ArrayList<Student> list_s;
    Student s;
    ViewStudent view;
    library input;

    public studentController() throws IOException {
        super("----------- Student Information -----------", new String[]{"Input student", "Sort and Display", "Exit"});
        input = new library();
        view = new ViewStudent(input);
        s = new Student();
        list_s = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> 
                view.inputStudent(list_s);
            case 2 -> 
                view.displaySortStudent(list_s);
            case 3 -> 
                System.exit(0);
        }
    }

}
