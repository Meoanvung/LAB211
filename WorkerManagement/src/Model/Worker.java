/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Worker {
    private int id;
    private String name;
    private int yearOfBirth;
    private double salary;
    private String workLocation;

    public Worker(){}
    
    public Worker(int id, String name, int yearOfBirth, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
        this.workLocation = workLocation;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return yearOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
}
