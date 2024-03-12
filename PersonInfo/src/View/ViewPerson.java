/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.library;
import Model.Person;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ViewPerson {

    private Person[] persons;
    private library input;

    public ViewPerson(library input) {
        this.input = input;
    }

    public void inputPersonInfo() {
        persons = new Person[3];
        //Person[] persons = new Person[3];
        for (int i = 0; i < persons.length; i++) {
            String name = input.getStringFromInput("Please input name: ");
            String address = input.getStringFromInput("Please input address: ");
            double salary = input.getdoubleFromInput("Please input salary: ");
            persons[i] = new Person(name, address, salary);
        }
    }
    
    public boolean hasPersons(){
    return persons != null & persons.length > 0;
    }
    
    public Person[] getPersons(){
    return persons;
    }

    public Person[] sortBySalary(Person[] persons) {
        Person o;
        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < persons.length; j++) {
                if (persons[i].getSalary() < persons[j].getSalary()) {
                    o = persons[i];
                    persons[i] = persons[j];
                    persons[j] = o;
                }
            }
        }
        return persons;
    }

    public void displayPerson(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].toString());
        }
    }
}
