/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Doctor {

    String newCode = "";
    String newName = "";
    String newSpecialization = "";
    int newAvailability = 0;

    //constructor 

    public Doctor() {
        super();
    }


    public Doctor(String newCode, String newName, String newSpecialization, int newAvailability) {
        this.newCode = newCode.toUpperCase();
        this.newName = newName.toUpperCase();
        this.newSpecialization = newSpecialization.toUpperCase();
        this.newAvailability = newAvailability;
    }

    // get data as a string for printing 
    @Override
    public String toString() {
        return newCode + ", " + newName + ", " + newSpecialization + ", " + newAvailability;
    }

    public String getNewCode() {
        return newCode;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        newName = newName.trim().toUpperCase();
        if (newName.length() > 0) {
            this.newName = newName;
        }
    }

    public String getnewSpecialization() {
        return newSpecialization;
    }

    public void setNewSpecialization(String newSpecialization) {
        newSpecialization = newSpecialization.trim().toUpperCase();
        this.newSpecialization = newSpecialization;
    }

    public int getNewAvailability() {
        return newAvailability;
    }

    public void setNewAvailability(int newAvailability) {
        this.newAvailability = newAvailability;
    }

}
