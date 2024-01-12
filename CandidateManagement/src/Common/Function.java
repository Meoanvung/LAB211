/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;
import java.util.List;
import java.util.ArrayList;
import Model.Candidate;

public interface Function {
    
    void addCandidate(ArrayList<Candidate> candidates, int type);
    void updateCandidate(Candidate candidates);
    void deleteCandidate(String id);
    void seacrhCandidate(ArrayList<Candidate> candidates);
    List<Candidate> getAllCandidates();
    Candidate getCandidateByID(String id);
    
}
