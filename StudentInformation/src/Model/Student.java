/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Student implements Comparable<Student> {

    private String name;
    private float mark;
    private String classes;

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public float getMark() {
        return mark;
    }

    public String getClasses() {
        return classes;
    }

    public Student(String name, float mark, String classes) {
        this.name = name;
        this.mark = mark;
        this.classes = classes;
    }

    public Student() {
    }

    @Override
    public int compareTo(Student o) {
      //  String compareName = ((Student) o).getName();
        return this.getName().compareTo(o.getName());
    }

}
