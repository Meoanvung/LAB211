/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Fresher extends Candidate{
    public String Gradate;
    public String GraRank;
    
    public Fresher(){
    super();
    }

    public Fresher(String Gradate, String GraRank, String id ,String firstName , String lastName , String Address ,String phone ,String email ,int birthDate , int typeCandidate) {
        this.Gradate = Gradate;
        this.GraRank = GraRank;
    }

    public void setGradate(String Gradate) {
        this.Gradate = Gradate;
    }

    public void setGraRank(String GraRank) {
        this.GraRank = GraRank;
    }

    public String getGradate() {
        return Gradate;
    }

    public String getGraRank() {
        return GraRank;
    }

}