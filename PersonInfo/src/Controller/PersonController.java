/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.library;
import Model.Person;
import View.Menu;
import View.ViewPerson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class PersonController extends Menu {

    // Person p;
    private ViewPerson view;
    library input;

    public PersonController() throws IOException {
        super("----------- Person Information -----------", new String[]{"Input person", "Sort and Display", "Exit"});
        input = new library();
        //view = new ViewPerson(input);
        view = new ViewPerson(new library());
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                view.inputPersonInfo();
                break;
            case 2:
                if (view.hasPersons()) {
                    Person[] persons = view.getPersons();
                    persons = view.sortBySalary(persons);
                    view.displayPerson(persons);
                } else {
                    System.out.println("Please input person information first.");
                }
                break;
            case 3:
                System.exit(0);
        }
    }
}
