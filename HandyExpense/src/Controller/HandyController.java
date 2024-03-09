/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Handy;
import Common.Library;
import View.ViewHandy;
import View.Menu;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HandyController extends Menu{
    ArrayList<Handy> list_h;
    Handy h;
    ViewHandy view;
    Library input;

    public HandyController() throws IOException {
        super("======= Handy Expense program =======", new String[]{"Add an expense", "Display all expenses", "Delete an expense", "Exit"});
        input = new Library();
        view = new ViewHandy(input);
        h = new Handy();
        list_h = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> 
                view.addExpense(list_h);
            case 2 -> 
                view.DisplayAll(list_h);
            case 3 ->
                 view.deleteExpense(list_h);
            case 4 -> 
                System.exit(0);
        }
    }
    
}
