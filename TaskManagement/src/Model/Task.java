/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Task {

    private int ID;
    private String Name;
    private int TypeID;
    private String date;
    private double from;
    private double to;
    private String Assignee;
    private String Reviewer;

    public Task(int ID, String Name, int TypeID, String date, double from, double to, String Assignee, String Reviewer) {
        this.ID = ID;
        this.Name = Name;
        this.TypeID = TypeID;
        this.date = date;
        this.from = from;
        this.to = to;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public Task() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    @Override
    public String toString() {
        return "Task{" + "ID=" + ID + ", Name=" + Name + ", TypeID=" + typeName() + ", date=" + date + ", from=" + from + ", to=" + to + ", Assignee=" + Assignee + ", Reviewer=" + Reviewer + '}';
    }

    public String typeName() {
        switch (TypeID) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4 :
                return "Review";
        }
        return null;
    }
}
