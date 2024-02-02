/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.function;
import Common.Inputter;
import Model.Doctor;
import View.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoctorController extends Menu {

    private function f;
    Inputter input;
    ArrayList<Doctor> list_d = new ArrayList<>();
    Doctor doctor;

    public DoctorController() {
        super("MENU", new String[]{"Add a doctor", "Update doctor", "Delete doctor", "Search doctor ", "Display list doctor", "Exit"});
        input = new Inputter();
        list_d = new ArrayList<>();
        f = new function();
    }

    @Override
    public void execute(int n) {
        try {
            switch (n) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    printAll();
                    break;
                case 6:
                    System.exit(0);

            }
        } catch (Exception e) {
            System.err.println("Error in execute: " + e.getMessage());
        }
    }

    private boolean checkExist(String code) {
        for (Doctor existingDoctor : list_d) {
            if (existingDoctor.getNewCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void addDoctor() throws Exception {
        try {
            String newName, newCode, newSpecialization;
            int newAvailability;

            newName = input.inputPattern("Enter the doctor name: ");
            boolean codeExist;
            newCode = input.getStringFromInput("Enter the doctor code: ");
            codeExist = checkExist(newCode);
            if (codeExist) {
                System.out.println("Doctor with the code " + newCode + " already exist");
            }
            newSpecialization = input.inputPattern("Enter doctor's specialization: ");
            newAvailability = input.getInt("Enter doctor's availability: ");

            Doctor newDoctor = new Doctor(newCode, newName, newSpecialization, newAvailability);
            f.addDoctor(newDoctor);
            System.out.println("Doctor added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Doctor findDoctorByCode(String codeToFind) {
        for (Doctor existingDoctor : list_d) {
            if (existingDoctor.getNewCode().equalsIgnoreCase(codeToFind)) {
                return existingDoctor;
            }
        }
        return null;
    }

    public void updateDoctor() throws Exception {
        String newCode = input.getStringFromInput("Enter the doctor code to update: ");
        Doctor existingDoctor = findDoctorByCode(newCode);

        if (existingDoctor != null) {
            String newName = input.inputPattern("Enter the new name:");
            String newSpecialization = input.inputPattern("Enter the new specialization: ");
            int newAvailability = input.getInt("Enter the new availability: ");

            existingDoctor.setNewName(newName);
            existingDoctor.setNewSpecialization(newSpecialization);
            existingDoctor.setNewAvailability(newAvailability);

            System.out.println("Doctor updated successfully");
        } else {
            System.out.println("Doctor with code " + newCode + " not found");
        }
    }

    public void deleteDoctor() throws Exception {
        String codeToDelete = input.getStringFromInput("Enter the doctor code to delete: ");
        Doctor doctorToDelete = findDoctorByCode(codeToDelete);

        if (doctorToDelete != null) {
            f.deleteDoctor(codeToDelete);
            System.out.println("Doctor deleted successfully");
        } else {
            System.out.println("Doctor with code " + codeToDelete + " not found");
        }
    }

    public void searchDoctor() throws Exception {
        String searchName = input.inputPattern("Enter doctor name to search: ");
        Map<String, Doctor> result = f.searchDoctor(searchName);
        for (Map.Entry<String, Doctor> entry : result.entrySet()) {
            Doctor doctor = entry.getValue();
            System.out.println("Doctor Found: " + doctor.toString());
        }
    }

    public void countDoctorsBySpecialization() {
        Map<String, Integer> specializationCount = new HashMap<>();

        for (Doctor doctor : list_d) {
            String specialization = doctor.getnewSpecialization();
            specializationCount.put(specialization, specializationCount.getOrDefault(specialization, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : specializationCount.entrySet()) {
            System.out.println("Specialization: " + entry.getKey() + ", Count: " + entry.getValue() + " doctor");
        }
    }

    public void printAll() {
        if (f.doctorMap.isEmpty()) {
            System.out.println("Empty list");
        } else {
            System.out.println("====================================================================");
            System.out.println("|                        🏥 DOCTOR LIST 🏥                          |");
            System.out.println("====================================================================");
            System.out.println(String.format("| %-10s | %-15s | %-18s | %-11s |", "Code", "Name", "Specialization", "Availability"));
            System.out.println("====================================================================");
            for (Map.Entry<String, Doctor> entry : f.doctorMap.entrySet()) {
                Doctor doctor = entry.getValue();
                String availability = doctor.getNewAvailability() + " days a week";
                System.out.println(String.format("| %-10s | %-15s | %-18s | %-10s |",
                        doctor.getNewCode(), doctor.getNewName(), doctor.getnewSpecialization(), availability));
            }
            System.out.println("Total: " + f.doctorMap.size() + " doctor ");
        }
    }

    public void Exit() {
        System.err.println("Exit! Bye Bye doctor");
    }
}
