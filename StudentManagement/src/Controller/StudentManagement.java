/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import Common.Validation;
import Model.CourseOfStudent;
import Model.Student;
import Model.CourseOfStudent;
import Model.Report;
import View.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DELL
 */
public class StudentManagement extends Menu {

    static String[] choice = {"Creat a student", "Find and Sort", "Update or Delete", "Report", "Exit"};
    Inputter input;
    ArrayList<Student> list_S;
    ArrayList<CourseOfStudent> list_C;
    Student s;

    public StudentManagement() {
        super("LAB211", choice);
        input = new Inputter();
        list_S = new ArrayList<>();
        list_C = new ArrayList<>();
        s = new Student();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createStudent();
                //DisplayStudentList();
                break;
            case 2:
                FindSortStudent();
                break;
            case 3:
                UpDeStudent();
                //DisplayStudentList();
                break;
            case 4:
                break;
            case 5:
                System.exit(0);

        }
    }

    public void createStudent() {
        String name;
        int id = input.getInt("Enter student id", 1, 1000);
        if (!checkID(list_S, id)) {
            name = input.getStringFromInput("");
            list_S.add(new Student(id, name));
        }
        int semester = input.getIntFromInput("Enter semester: ");
        String courseName = input.inputPattern("Enter course name: ");
        list_C.add(new CourseOfStudent(id, semester, courseName));
    }

    public void FindSortStudent() {
        if (list_S.isEmpty()) {
            System.err.println("Not Exist! please check again");
            return;
        }
        ArrayList<Student> FindByName = FindByName(list_S);
        if (FindByName.isEmpty()) {
            System.err.println("Not exist! please check again");
        } else {
            Collections.sort(FindByName);
            DisplayStudentList(FindByName);
        }

    }

    public ArrayList<Student> FindByName(ArrayList<Student> list_S) {
        ArrayList<Student> FoundStudent = new ArrayList<Student>();
        String name = input.getStringFromInput(" ");
        for (Student s : list_S) {
            if (s.getName().contains(name)) {
                FoundStudent.add(s);
            }
        }
        return FoundStudent;
    }

    public void UpDeStudent() {
        if (list_S.isEmpty()) {
            System.err.println("The student list is empty! please create first");
            return;
        }
        int id = input.getInt("Enter the id to search: ", 1, 1000);
        ArrayList<Student> list_ID = listById(list_S, id);
        ArrayList<CourseOfStudent> ID_cs = ID_cs(list_C, id);

        if (list_ID == null || ID_cs == null) {
            System.err.println("Student not exist");
        } else {
            System.out.println("Do you want to update or delete ? ");
            System.out.println("1. Update student ");
            System.out.println("2. Delete student ");
            Student s = list_ID.get(0);
            CourseOfStudent cs = ID_cs.get(0);
            int o = input.getInt("Enter your choice ", 1, 2);
            switch (o) {
                case 1:
                    s.setId(id);
                    s.setName(input.getStringFromInput(""));
                    cs.setId(id);
                    cs.setSemester(input.getIntFromInput(""));
                    cs.setCourseName(input.inputPattern("Enter course name: "));
                    System.out.println("Updated success!");
                    break;
                case 2:
                    list_C.remove(cs);
                    list_S.remove(s);
                    System.out.println("Delete success!");
                    break;
                default:
                    return;
            }
        }

    }

    public void DisplayStudentList(ArrayList<Student> list_S) {
        for (Student s : list_S) {
            System.out.print("[" + "id: " + s.getId() + ", " + "Name: " + s.getName() + "]");

            for (CourseOfStudent cs : list_C) {
                if (s.getId() == cs.getId()) {
                    System.out.println("[" + "semester: " + cs.getSemester() + ", " + "course Name: " + cs.getCourseName() + "]");

                }
            }
        }
    }

    public boolean checkID(ArrayList<Student> list, int id) {
        if (list.isEmpty()) {
            return false;
        } else {
            for (Student s : list_S) {
                if (s.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    public Student searchID(int id) {
        for (Student s : list_S) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    } */
    public ArrayList<Student> listById(ArrayList<Student> list_s, int id) {
        ArrayList<Student> Found = new ArrayList<Student>();
        for (Student s : list_S) {
            if (s.getId() == id) {
                Found.add(s);
            }
        }
        return Found;
    }

    public ArrayList<CourseOfStudent> ID_cs(ArrayList<CourseOfStudent> list_s, int id) {
        ArrayList<CourseOfStudent> Found = new ArrayList<CourseOfStudent>();
        for (CourseOfStudent s : list_s) {
            if (s.getId() == id) {
                Found.add(s);
            }
        }

        return Found;
    }

    public Student GetById(int id) {
        for (Student st : list_S) {
            if (st.getId() == id) {
                return st;
            }
        }
        return null;
    }
}
