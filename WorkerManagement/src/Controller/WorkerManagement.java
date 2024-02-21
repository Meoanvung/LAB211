/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import Model.SalaryHistory;
import Model.Worker;
import Utils.Function;
import View.Menu;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class WorkerManagement extends Menu {
   
    Function f;
    Inputter input;
    ArrayList<Worker> list_w;
    ArrayList<SalaryHistory> list_s;
    Worker w;

    public WorkerManagement() {
        super("----------- worker management -----------", new String[]{"Add worker", "Increase salary", "Decrease salary", "Display the list worker have been adjusted salary", "Exit"});
        input = new Inputter();
        f = new Function(input);
        list_w = new ArrayList<>();
        list_s = new ArrayList<>();
        w = new Worker();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
                f.addWorker(list_w);
            case 2 ->
                f.increaseSalary(list_w, list_s);
            case 3 ->
                f.decreaseSalary(list_w, list_s);
            case 4 ->
                f.DisplayHistory(list_s);
            case 5 ->
                System.exit(0);
        }
    }
}
