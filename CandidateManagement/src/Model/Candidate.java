/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Candidate {
    public String id;
    public String firstName;
    public String lastName;
    public String Address;
    public String phone;
    public String email;
    public int birthDate;
    public int typeCandidate;
    
    public Candidate(){
    this.id = "";
    this.firstName = "";
    this.lastName = "";
    this.Address = "";
    this.phone = "";
    this.email = "";
    this.birthDate = 0;
    this.typeCandidate = 0;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public int getTypeCandidate() {
        return typeCandidate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public void setTypeCandidate(int typeCandidate) {
        this.typeCandidate = typeCandidate;
    }

    @Override
    public String toString() {
        return "Candidate{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address + ", phone=" + phone + ", email=" + email + ", birthDate=" + birthDate + ", typeCandidate=" + typeCandidate + '}';
    }

    public Candidate(String id, String firstName, String lastName, String Address, String phone, String email, int birthDate, int typeCandidate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = Address;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.typeCandidate = typeCandidate;
    }

   
    
}
