/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.Library;
import Common.Validation;
import Model.Task;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ViewTask {

    private Task t = new Task();
    Library input;
    ArrayList<Task> list_t = new ArrayList<>();
    Validation v;
    
    public ViewTask() {
        t = new Task();
        v = new Validation();
    }

    public ViewTask(Library input) {
        this();
        this.input = input;
    }

    public void addTask(ArrayList<Task> list_t) {
        System.out.println("-------- Add new task--------");
        int ID = generateID(list_t);
        String Name = input.getStringFromInput("Enter Requirement name: ");
        int TypeID = input.getTypeID("Enter type id: ");
        String date = v.checkDate("Enter date: ");
        double from = input.getDoubleFrom("Enter time from: ");
        double to = input.getDoubleTo("Enter time to: ", from);        
        String Assignee = input.getStringFromInput("Enter Assignee: ");
        String Reviewer = input.getStringFromInput("Enter reviewer: ");
        list_t.add(new Task(ID, Name, TypeID, date, from, to, Assignee, Reviewer));
        System.out.println("Add task successfully!");
    }

    public int generateID(ArrayList<Task> list_t) {
        int id = 0;
        if (list_t.isEmpty()) {
            return 1;
        } else {
            for (Task t : list_t) {
                if (t.getID() == list_t.size()) {
                    id = t.getID() + 1;
                }
            }
        }
        return id;
    }

    public void getDataTask(ArrayList<Task> list_t) {
        if (list_t.isEmpty()) {
            System.err.println("the list task is empty ! please check again");
            return;
        } else {
            System.out.println("------------------------------Display all Task-----------------------------------");
            System.out.printf("| %-5s | %-13s | %-9s | %-10s | %-7s | %-7s | %-7s%n", "ID", "Name", "Task Type","Date","Time","Assignee", "Reviewer");
            System.out.println("=================================================================================");
            for (Task t : list_t) {
                System.out.printf("| %-5s | %-13s | %-9s | %-10s | %-7s | %-7s | %-7s%n", t.getID(), t.getName(), t.typeName(), t.getDate(), t.getTo() - t.getFrom(), t.getAssignee(), t.getReviewer());
            }
        }
    }
        
    public boolean deleteTask(ArrayList<Task> list_t) {
        System.out.println("--------Delete task ------");
        int code = input.getIntFromInput("Enter code(id) to delete: ");
        Task t = GetById(list_t, code);
        if (t != null) {
            boolean success = list_t.remove(t);
            if (success) {
                System.out.println("DELETE SUCESSFULLY !!");
            } else {
                System.out.println("Failed to delete task");
            }
            return success;
        } else {
            System.err.println("The id not exist!");
            return false;
        }
    }

    public Task GetById(ArrayList<Task> list_t, int code) {
        for (Task t : list_t) {
            if (code == t.getID()) {
                return t;
            }
        }
        return null;
    }

}
