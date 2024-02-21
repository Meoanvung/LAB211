/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.Worker;
import Model.SalaryHistory;
import Common.Inputter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Function {

    Inputter input;
    ArrayList<Worker> list_w;
    ArrayList<SalaryHistory> list_s;
    Worker w;

    public Function(Inputter input) {
        this.input = input;
        list_w = new ArrayList<>();
        list_s = new ArrayList<>();
    }

    public void addWorker(ArrayList<Worker> list_w) {
        int id = generateID(list_w);
        String name = input.getStringFromInput("Enter name: ");
        int yearOfBirth = input.getIntFromInput("Enter year of birth: "); 

        int age = getAgeFromYearOfBirth(yearOfBirth); //Lấy tuổi từ năm sinh
        if (age != -1) {
            double salary = input.getDoubleFromInput("Enter salary: ");
            String workLocation = input.getStringFromInput("Enter work's location: ");
            list_w.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add new contact successful!");
        } else {
            System.err.println("Year of birth must be between 18 and 50!");
        }
    }

    public int generateID(ArrayList<Worker> list_w) {
        int id = 0;
        if (list_w.isEmpty()) {
            return 1;
        } else {
            for (Worker w : list_w) {
                if (w.getId() == list_w.size()) {
                    id = w.getId() + 1;
                }
            }
        }
        return id;
    }

    public void increaseSalary(ArrayList<Worker> list_w, ArrayList<SalaryHistory> list_s) {
        int code = input.getIntFromInput("Enter code(id): ");
        Worker w = GetById(list_w, code);
        if (w != null) {
            double salary = input.getDoubleFromInput("Enter salary: ");
            if (salary > 0) {
                double salaryCurrent = w.getSalary();
                double totalSalary = salaryCurrent + salary;
                list_s.add(new SalaryHistory(w.getId(), w.getName(), w.getAge(), totalSalary, w.getWorkLocation(), "UP", currentDate()));
                w.setSalary(totalSalary);
            } else {
                System.err.println("Salary must be > 0!");
            }
        } else {
            System.err.println("The code not exist!");
        }
    }

    public void decreaseSalary(ArrayList<Worker> list_w, ArrayList<SalaryHistory> list_s) {
        int code = input.getIntFromInput("Enter code(id): ");
        Worker w = GetById(list_w, code);
        if (w != null) {
            double salary = input.getDoubleFromInput("Enter salary: ");
            if (salary > 0) {
                double salaryCurrent = w.getSalary();
                if (salaryCurrent > salary) {
                    double totalSalary = salaryCurrent - salary;
                    list_s.add(new SalaryHistory(w.getId(), w.getName(), w.getAge(), totalSalary, w.getWorkLocation(), "DOWN", currentDate()));
                    w.setSalary(totalSalary);
                } else {
                    System.err.println("The salary must < salary current!");
                }
            } else {
                System.err.println("Salary must be > 0!");
            }
        } else {
            System.err.println("The code not exist!");
        }
    }

    public Worker GetById(ArrayList<Worker> list_w, int code) {
        for (Worker w : list_w) {
            if (code == w.getId()) {
                return w;
            }
        }
        return null;
    }

    public String currentDate() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar rightNow = Calendar.getInstance();
        return date.format(rightNow.getTime());
    }

    public int getAgeFromYearOfBirth(int yearOfBirth) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int age = currentYear - yearOfBirth;

        if (age >= 18 && age <= 50) {
            return age;
        } else {
            return -1; // Nếu năm sinh không hợp lệ, trả về -1
        }
    }

    public void DisplayHistory(ArrayList<SalaryHistory> list_s) {
        if (list_s.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Collections.sort(list_s);
            System.out.println("---------- Display information salary ----------");
            System.out.printf("| %-5s | %-7s | %-7s | %-10s | %-7s | %-15s%n", "Code", "Name", "Age", "Salary", "Status", "Date");
            System.out.println("=======================================================================");
            for (SalaryHistory s : list_s) {
                System.out.printf("| %-5s | %-7s | %-7s | %-10s | %-7s | %-15s%n", s.getId(), s.getName(), s.getAge(), s.getSalary(), s.getStatus(), s.getDate());
            }
        }
    }

    public void display(ArrayList<Worker> list_w) {
        if (list_w.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            for (Worker w : list_w) {
                System.out.println("id: " + w.getId() + "-Name: " + w.getName() + "-Age: " + w.getAge() + "-Salary: " + w.getSalary());
            }
        }
    }
}
