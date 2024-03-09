/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.Library;
import Common.Validation;
import Model.Handy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ViewHandy {

    Validation v;
    private Handy h = new Handy();
    Library input;
    ArrayList<Handy> list_h = new ArrayList<>();

    public ViewHandy() {
        h = new Handy();
        v = new Validation();
    }

    public ViewHandy(Library input) {
        this();
        this.input = input;
    }

    public boolean addExpense(ArrayList<Handy> list_h) {
        System.out.println("-------- Add an expense--------");
        int ID = generateID(list_h);
        //Date date = input.getDateFromInput("Enter date: "); kiểu code khác nma kiểu dữ liệu phải là Date
        String date = v.checkDate("Enter date (dd/MM/yyyy): ");
        double amount = input.getDoubleFromInput("Enter amount of money: ");
        String content = input.getStringFromInput("Enter content: ");
        boolean success = list_h.add(new Handy(ID, date, amount, content));
        if (success) {
            System.out.println("ADD SUCESSFULLY !!");
        } else {
            System.out.println("Failed to add new expense");
        }
        return success;
    }

    public int generateID(ArrayList<Handy> list_h) {
        int id = 0;
        if (list_h.isEmpty()) {
            return 1;
        } else {
            for (Handy h : list_h) {
                if (h.getID() == list_h.size()) {
                    id = h.getID() + 1;
                }
            }
        }
        return id;
    }

    public void DisplayAll(ArrayList<Handy> list_h) {
        double total = 0;
        if (list_h.isEmpty()) {
            System.err.println("the list expense is empty ! please check again");
            return;
        } else {
            System.out.println("----------------Display all expenses------------------");
            System.out.printf("| %-5s | %-15s | %-10s | %-10s%n", "ID", "Date", "Amount", "Content");
            System.out.println("=======================================================");
            for (Handy h : list_h) {
                System.out.printf("| %-5s | %-15s | %-10s | %-10s%n", h.getID(), h.getDate(), h.getAmount(), h.getContent());
                total += h.getAmount();
            }
            System.out.println("Total of amount: " + total);
        }

    }

    public boolean deleteExpense(ArrayList<Handy> list_h) {
        System.out.println("--------Delete an expense------");
        int code = input.getIntFromInput("Enter code(id) to delete: ");
        Handy h = GetById(list_h, code);
        if (h != null) {
            boolean success = list_h.remove(h);
            if (success) {
                System.out.println("DELETE SUCESSFULLY !!");
            } else {
                System.out.println("Failed to delete expense");
            }
            return success;
        } else {
            System.err.println("The id not exist!");
            return false;
        }
    }

    public Handy GetById(ArrayList<Handy> list_h, int code) {
        for (Handy h : list_h) {
            if (code == h.getID()) {
                return h;
            }
        }
        return null;
    }

    public String currentDate() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar rightNow = Calendar.getInstance();
        return date.format(rightNow.getTime());
    }
}
