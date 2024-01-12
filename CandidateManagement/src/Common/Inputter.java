/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import Common.Validation;
import java.util.Scanner;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import java.util.ArrayList;
import java.util.Calendar;

public class Inputter {

    private Validation validator = new Validation();
    public Candidate candidate = null;

    public Inputter instance = null;

    public Inputter Instance() {
        if (instance == null) {
            synchronized (Inputter.class) {
                if (instance == null) {
                    instance = new Inputter();
                }
            }
        }
        return instance;
    }

    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.print("Enter id: ");
            String id = validator.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = validator.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = validator.checkInputString();
            System.out.print("Enter birth Date: ");
            int birthDate = validator.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String Address = validator.checkInputString();
            System.out.print("Enter number phone: ");
            String phone = validator.checkInputPhone();
            System.out.print("Enter mail: ");
            String email = validator.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName, Address, phone, email, birthDate, type) {
            };
        }
        if (!validator.checkIdExist(candidates, id)) {
            switch (type) {
                case 0:
                  createExperience(candidates, candidate);
                    break;
                case 1:
                   createFresher(candidates, candidate);
                    break;
                case 2:
                    createInter(candidates, candidate);
                    break;
            }
        } else {
            return;
        }
        System.out.print("Do you want to continue (Y/N): ");
        if (!validator.checkInputYN()) {
            return;
        }
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate1) {
    System.out.print("Enter year of experience: ");
    int ExperienceInYear = validator.checkInputExprience(candidate.getBirthDate());
    System.out.print("Enter professional skill: ");
    String professionalSkill = validator.checkInputString();
    candidates.add(new Experience ( ExperienceInYear, professionalSkill,
    candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getBirthDate(), candidate.getTypeCandidate()));
        System.err.println("Create success!");
        //return new Experience(ExperienceInYear, professionalSkill, id, firstName, lastName, Address, phone, email, birthDate, type);
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate1) {
    System.out.print("Enter graduation date: ");
    String gradate = validator.checkInputString();
    System.out.print("Enter graduation rank: ");
    String graRank = validator.checkInputGraduationRank();
    candidates.add(new Fresher ( gradate, graRank, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getBirthDate(), candidate.getTypeCandidate()));
        System.err.println("Create success!");
    }
    public void createInter(ArrayList<Candidate> candidates, Candidate candidate1) {
        System.out.print("Enter major: ");
        String major = validator.checkInputString();
        System.out.print("Enter semester: ");
        String semester = validator.checkInputString();
        System.out.print("Enter university: ");
        String university = validator.checkInputString();
        candidates.add(new Intern (major, semester, university, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getBirthDate(), candidate.getTypeCandidate() ));
        System.err.println("Create success.");
    }
    
    public  void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = validator.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = validator.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }
    
    //display list name candidate
    public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Intern) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
    
}
