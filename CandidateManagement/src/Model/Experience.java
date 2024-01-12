/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Experience extends Candidate {
    public int ExpInYear;
    public String ProSkill;
    
    
    public Experience(){
    super();
    } 
    
    public Experience(int ExpInyear, String ProSkill ,String id ,String firstName , String lastName , String Address ,String phone ,String email ,int birthDate , int typeCandidate) {
    //super(id, firstName, lastName, birthDate, Address, phone, email, typeCandidate);   
    this.ExpInYear = ExpInYear;
    this.ProSkill = ProSkill;
    }
    
    public int getExpInYear() {
        return ExpInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }
}
