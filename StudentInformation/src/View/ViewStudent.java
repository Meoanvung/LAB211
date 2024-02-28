/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Student;
import Common.library;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class ViewStudent {

    private Student st = new Student();
    library input;
    ArrayList<Student> list_s = new ArrayList<>();

    public ViewStudent() {
        st = new Student();
    }

    public ViewStudent(library input) {
        this();
        this.input = input;
    }

    public void inputStudent(ArrayList<Student> list_s) {
        String name = input.getStringFromInput("Enter name: ");
        float mark = input.getFloatFromInput("Enter mark: ");
        String classes = input.getStringFromInput("Enter classes: ");
        list_s.add(new Student(name, mark, classes));
        
        if (list_s.size() >= 1) {
            char continueInput = input.getYN("Do you want to continue (Y/N)? ");
            if (Character.toUpperCase(continueInput) != 'Y') {
                return;
            }
        }

    }

    public void displaySortStudent(ArrayList<Student> list_s) {
        if (list_s.isEmpty()) {
            System.err.println("the list is empty ! please check again");
            return;
        } else {
            Collections.sort(list_s);
            System.out.println("---------- Display information salary ----------");
            System.out.printf("| %-9s | %-5s | %-10s%n", "Name", "Mark", "Classes");
            System.out.println("=========================================");
            for (Student s : list_s) {
                System.out.printf("|%-9s | %-5s | %-10s%n", s.getName(), s.getMark(), s.getClasses());

            }
        }

    }
}
