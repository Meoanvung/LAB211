/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Library;
import Model.Task;
import View.Menu;
import View.ViewTask;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class TaskController extends Menu{
    ArrayList<Task> list_t;
    Task t;
    ViewTask view;
    Library input;

    public TaskController() throws IOException {
        super("======= Task Manage program =======", new String[]{"Add task",  "Delete task", "Display all task", "Exit"});
        input = new Library();
        view = new ViewTask(input);
        t = new Task();
        list_t = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> 
                view.addTask(list_t);
            case 2 -> 
                view.deleteTask(list_t);
            case 3 ->
                 view.getDataTask(list_t);
            case 4 -> 
                System.exit(0);
        }
    }
    
}
