/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;
import Model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import Common.Inputter;

public class Validation {

    private final Scanner in = new Scanner(System.in);
    /*
    \\d{10} user must be input 10 number
    \\d* user can input more number or not
     */
    public final String PHONE_VALID = "^\\d{10}\\d*$";

    /*
    [A-Za-z0-9.-+%]+ user must be input from a-z ignore case,0-9 and .-+% least one times
    @ user must be input "@"
    [A-Za-z.-]+ user mustbe input from a-z ignore case, "." "-" least one times
    \\. user must be input "."
    [A-Za-z]{2,4} user must be input from a-z ignore 2 - 4 times
     */
    private final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input y/Y or n/N
    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check phone is number with minimum 10 characters
    public String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            //check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    //check email with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
    public String checkInputEmail() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input graduation rank
    public String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    //check id exist or not
    public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    //check experience must be smaller then age
    public int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }
}

/*
public class Inputter {
    private Inputter input;
    private Scanner sc;

    public Inputter() {
        this.input = new Inputter();
        this.sc = new Scanner(System.in);
    }

    public String getString(String name) {
        String str;
        while (true) {
            System.out.print("Enter " + name + " : ");
            str = sc.nextLine().trim();
            if (input.checkEmpty(str)) {
                System.err.println(name + " can not empty..");
            } else {
                return str;
            }
        }
    }

    public int getInt(String name) {
        int n;
        while (true) {
            try {
                System.out.print("Enter " + name + " : ");
                n = Integer.parseInt(sc.nextLine());
                if (input.checkPositiveNumber(n)) {
                    return n;
                } else {
                    System.err.println(name + " can must positive..");
                }
            } catch (Exception e) {
                System.err.println("Enter number please..");
            }
        }

    }

    public double getDouble(String name) {
        double n;
        while (true) {
            try {
                System.out.print("Enter " + name + " : ");
                n = Double.parseDouble(sc.nextLine());
                if (input.checkPositiveNumber(n)) {
                    return n;
                } else {
                    System.err.println(name + " must be positive..");
                }
            } catch (Exception e) {
                System.err.println("Enter number please..");
            }
        }

    }

    public String getPhone() {
        String phone;
        
        while (true) {            
            System.out.print("Enter phone : ");
            phone = sc.nextLine().trim(); 
            if(phone.matches("\\d{10}")){
            return phone ; 
            }else{
                System.err.println("Phone must be 10 digits...");
            }
        }
    }
}

*/