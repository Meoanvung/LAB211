/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;
import Model.Candidate;
import java.util.ArrayList;
import java.util.List;
import Common.Inputter;
public class Data implements Function{
   public List<Candidate> candidates;
    
   public Data(){
   this.candidates = new ArrayList<>();
   }
   
    @Override
    public void addCandidate(ArrayList<Candidate> candidates, int type) {
    Inputter.Instance().createCandidate(candidates, type);
    }

    @Override
    public void updateCandidate(Candidate candidates) {
    
    }

    @Override
    public void deleteCandidate(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void seacrhCandidate(ArrayList<Candidate> candidates) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Candidate> getAllCandidates() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Candidate getCandidateByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
