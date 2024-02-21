/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class SalaryHistory extends Worker implements Comparable<SalaryHistory>{
    private String status;
    private String date;
    
    public SalaryHistory(){}
    
    public SalaryHistory(int id, String name, int yearOfBirth, double salary, String workLocation,String status, String date) {
        super(id,name, yearOfBirth, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(SalaryHistory o) {
    int compareID = ((SalaryHistory)o).getId();
    return this.getId() - compareID;
    }

}
