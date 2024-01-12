/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Intern extends Candidate{
    private String major;
    private String semester;
    private String university;
    
    public Intern(){
    super();
    }

    public Intern(String major, String semester, String university, String id ,String firstName , String lastName , String Address ,String phone ,String email ,int birthDate , int typeCandidate) {
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    
}
