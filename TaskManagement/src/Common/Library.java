/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Library {

    public Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    private static final String DATE_FORMAT = "yyyy/MM/dd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public int getTypeID(String msg) {
        Scanner sc = new Scanner(System.in);
        int ID = 0;
        while (true) {
            try {
                System.out.print(String.format("%s", msg));
                ID = Integer.parseInt(sc.nextLine());
                if (ID >= 1 && ID <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("invalid type id, please input again!");
            }
        }
        return ID;
    }

    public double getDoubleFrom(String msg) {
        Scanner sc = new Scanner(System.in);
        double from;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                from = sc.nextDouble();
                if (from >= 8 && from <= 17.5) {
                    if (from % 0.5 == 0) {
                        return from;
                    }
                } else {
                    System.err.println("Please enter the time from >= 8");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the double number > 0 ");
                sc.next();
            }
        }
    }

    public double getDoubleTo(String msg, double from) {
    Scanner sc = new Scanner(System.in);
    double to;
    while (true) {
        System.out.print(String.format("%s", msg));
        try {
            to = sc.nextDouble();
            if (to >= 8 && to <= 17.5) {
                if (to % 0.5 == 0) {
                    if (to > from) {
                        return to;
                    } else {
                        throw new IllegalArgumentException("The time to must < the number from");
                    }
                }
            } else {
                System.err.println("Please enter a number between 8 and 17.5 (inclusive) in increments of 0.5");
            }
        } catch (InputMismatchException e) {
            System.err.println("Please enter a valid number");
            sc.next();
        }
    }
}

    public float getFloatFromInput(String msg, float min) {
        Scanner sc = new Scanner(System.in);
        float number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextFloat();
                if (number > min) {
                    return number;
                } else {
                    System.err.println("Please enter the float number > " + min);
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the float number > 0 ");
                sc.next();
            }
        }
    }

    public int getIntFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the integer number > 0 ");
                sc.next();
            }
        }
    }

    public Date getDateFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(String.format("Enter %s: ", msg));
            String dateString = sc.nextLine();
            if (!dateString.isEmpty()) {
                try {
                    Date date = dateFormat.parse(dateString);
                    return date;
                } catch (ParseException e) {
                    System.err.println(String.format("Invalid date format. Please enter again (%s).", DATE_FORMAT));
                }
            }
        }
    }

    public String getStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("%s", msg));
            s = sc.nextLine();
        }
        return s;
    }

    public char getCharFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        char c = '\0';  // Default value
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print(String.format("%s", msg));
            String input = sc.nextLine().trim();

            if (input.length() == 1) {
                c = input.charAt(0);
                isValidInput = true;
            } else {
                System.out.println("Please enter a single character.");
            }
        }

        return c;
    }

    public String getAlphabelticStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches("[a-zA-Z\\s]{0,30}+$"));
        return data;
    }

    public String inputPattern(String msg, String pattern) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches(pattern));
        return data;
    }

    public int inputPositiveInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number > 0 && number < 10000) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {//exception về datatype của đầu vào
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }

    public int inputChoiceHasLimit(List<String> msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            for (int i = 0; i < msg.size(); i++) {
                System.out.println((i + 1) + ". " + msg.get(i));
            }
            try {
                number = sc.nextInt();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number from " + min + " to " + max);
                }
            } catch (InputMismatchException e) {//exception về datatype của đầu vào
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter a number from " + m + " to " + n);
            }
        }
        return a;
    }

    public int getIDFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("ID is digit ");
                sc.next();
            }
        }
    }

}
