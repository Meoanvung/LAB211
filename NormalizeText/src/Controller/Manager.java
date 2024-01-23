/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import View.Menu;
import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Manager extends Menu {

    static String[] choice = {"Input a String", "Normalize content file", "check it", "Exit"};
    Inputter input;

    public Manager() {
        super("We will normalize your content file", choice);
        input = new Inputter();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                InLine();
                break;
            case 2:
                if(!isFileEmpty("input.txt")) {
                 System.out.println("we can not normalize because the file is empty");}
                else {NormalizeContent();}
                break;
            case 3:
                // kiểm tra xem chuỗi đã được mã hóa chưa 
                break;
            case 4:
                System.exit(0);

        }
    }

    public void InLine() {
        String userInput = input.inputString("Enter a string: ");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
                writer.write(userInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Content has been written to text.txt");
    }

    public void NormalizeContent() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt")); BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) { // đọc 1 dòng từ buffered , gán nội dung của dòng vừa đọc vào 'line', ktra xem dòng dọc còn giá trị ko, nếu dòng cuối cùng đã đc đọc thì 'readline()' sẽ trả về null, loop sẽ stop
                // chuẩn hóa nội dung ở đây
                line = OneSpace(line);
                line = SpecialCharacter(line);
                line = afterDot(line);
                line = noSpaceQuotes(line);
                line = firstUpercase(line);
                line = AddDotEnd(line);

                content.append(line).append("\n");
            }
            writer.write(content.toString());
            System.out.println("Content has been normalized and written to output.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Can't not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String formatOneSpace(String line, String character) {
        StringBuffer bf = new StringBuffer();
        String[] a = line.split("\\s*\\" + character + "\\s*");
        // khoảng cách giữa mỗi từ và kí tự đặc biệt chỉ vs 1 khoảng trắng
        for (String word : a) {
            bf.append(word + " " + character);
            bf.append(" ");
        }
        return bf.toString().trim().substring(0, bf.length() - 3);

    }

    // chỉ có 1 khoảng trắng giữa các từ và các từ viết thg
    public String OneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpace(line, ".");
        line = formatOneSpace(line, ",");
        line = formatOneSpace(line, ":");
        line = formatOneSpace(line, "\"");
        return line.trim();
    }

    // chỉ có space sau dấu , và dấu . và dấu : 
    public String SpecialCharacter(String line) {
        StringBuffer bf = new StringBuffer(line);
        // chạy loop từ đầu tới cuối trc các dấu, sau đó xóa
        for (int i = 0; i < bf.length() - 1; i++) {
            if (bf.charAt(i) == ' ' && bf.charAt(i + 1) == '.'
                    || bf.charAt(i + 1) == ',' || bf.charAt(i + 1) == ':') {
                bf.deleteCharAt(i);
            }
        }
        return bf.toString().trim();
    }

    //Ghi hoa từ đầu tiên của chữ
    /*
    public String firstUppercase(String line) {
        StringBuilder bd = new StringBuilder(line.trim());
        boolean foundFirst = false; // khởi tạo biến boolean để theo dõi việc tìm kiếm ký tự đầu tiên của 1 từ
        for (int i = 0; i < bd.length(); i++) {
            char current = bd.charAt(i); // lấy ký tự hiện tại tại 'i' trong bd
            if (Character.isLetter(current)) {
                if (!foundFirst) {
                    bd.setCharAt(i, Character.toUpperCase(current));
                    foundFirst = true;
                }
            } else {
                foundFirst = false;
            }
        }
        return bd.toString();
    }
     */
    public static String firstUpercase(String line) {
        StringBuffer bf = new StringBuffer(line.trim());
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                bf.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return bf.toString().trim();
    }

    // Sau dấu chấm phải ghi hoa kí tự đầu tiên
    public String afterDot(String line) {
        StringBuffer bf = new StringBuffer(line);
        for (int i = 0; i < bf.length() - 2; i++) {
            if (bf.charAt(i) == '.') {
                char afterDot = bf.charAt(i + 2);
                bf.setCharAt(i + 2, Character.toUpperCase(afterDot));
            }
        }
        return bf.toString().trim();
    }

    //no spaces before and after sentence or word phrases in quotes (“”).
    public String noSpaceQuotes(String line) {
        StringBuffer bf = new StringBuffer(line);
        int countQuotes = 0;
        for (int i = 0; i < bf.length(); i++) {
            if (bf.charAt(i) == '"' && countQuotes % 2 == 0) {
                bf.deleteCharAt(i + 1);
                countQuotes++;
            } else if (bf.charAt(i) == '"' && countQuotes % 2 == 1 && i != 0) {
                bf.deleteCharAt(i - 1);
                countQuotes++;
            }
        }
        return bf.toString().trim();
    }

    public String AddDotEnd(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

    //There are no blank line between lines
    public boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    
    public boolean isFileEmpty(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            return reader.readLine() == null; // Trả về true nếu file rỗng, ngược lại là false
        } catch (IOException e) {
            e.printStackTrace();
            return true; // Xem như file rỗng nếu có lỗi khi đọc
        }
    } 
}
