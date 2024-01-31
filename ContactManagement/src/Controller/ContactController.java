/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import Model.Contact;
import View.Menu;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ContactController extends Menu {

    private final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    static String[] choice = {"Add a contact", "Display all contact", "Delete a contact", "Exit"};
    Inputter input;
    ArrayList<Contact> list_c = new ArrayList<>();
    Contact co;

    public ContactController() {
        super("MENU", choice);
        input = new Inputter();
        list_c = new ArrayList<>();
        co = new Contact();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createContact(list_c);
                break;
            case 2:
                DisplayFruittList(list_c);
                break;
            case 3:
                deleteContact(list_c);
                break;
            case 4:
                System.exit(0);

        }
    }

    public void createContact(ArrayList<Contact> list_c) {
        int id = generateID(list_c);
        String firstName = input.getStringFromInput("Enter first name: ");
        String lastName = input.getStringFromInput("Enter last name: ");
        String group = input.getStringFromInput("Enter group: ");
        String address = input.getStringFromInput("Enter address: ");
        String phone = checkPhone();
        list_c.add(new Contact(id, firstName + " " + lastName, group, address, phone, firstName, lastName));
        System.err.println("Add new contact successful!");
    }

    public int generateID(ArrayList<Contact> list_c) {
        int id = 0;
        if (list_c.isEmpty()) {
            return 1;
        } else {
            for (Contact c : list_c) {
                if (c.getId() == list_c.size()) {
                    id = c.getId() + 1;
                }
            }
        }
        return id;
    }

    public String checkPhone() {
        //loop until user input correct
        while (true) {
            String result = input.getStringFromInput("Enter phone number: ");
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone folow\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Enter again: ");
        }
    }

    public void DisplayFruittList(ArrayList<Contact> list_c) {
        if (list_c.isEmpty()) {
            System.out.println("The list contact is empty, please add first");
        } else {
            System.out.printf("| %-5s | %-13s | %-10s | %-10s | %-10s | %-15s | %-13s%n", "id", "Full Name", "First Name", "Last Name", "Group", "Address", "Phone");
            System.out.println("==============================================================================================");
            for (Contact c : list_c) {
                System.out.printf("| %-5s | %-13s | %-10s | %-10s | %-10s | %-15s | %-13s%n", c.getId(), c.getFullName(), c.getFirstName(), c.getLastName(), c.getGroup(), c.getAddress(), c.getPhone());
            }
        }
    }

    public Contact GetById(ArrayList<Contact> list_c, int idDelete) {
        for (Contact c : list_c) {
            if (c.getId() == idDelete) {
                return c;
            }
        }
        return null;
    }

    public void deleteContact(ArrayList<Contact> list_c) {
        int idDelete = input.getInt("Enter id to delete: ");
        Contact c = GetById(list_c, idDelete);
        if (c == null) {
            System.out.println("The contact isn't exit");
        } else {
            list_c.remove(c);
        }
        System.out.println("Delete contact succesful!");
    }

}
