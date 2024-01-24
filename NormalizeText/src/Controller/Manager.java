/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import Model.InOu;
import View.Menu;
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

    static String[] choice = {"load from file", "Normalize content file", "Exit"};
    Inputter input;
    InOu inOu;
    private String loadedContent;

    public Manager() {
        super("We will normalize your content file", choice);
        input = new Inputter();
        inOu = new InOu();
        inOu.setInputFile("input.txt");
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                loadFromFile("input.txt");
                break;
            case 2:
                if (inOu != null && isFileEmpty(inOu.getInputFile())) { // Fix: Đảo ngược điều kiện
                    System.out.println("we can not normalize because the file is empty");
                } else {
                    normalizeAndSave(inOu.getInputFile());
                }
                break;
            case 3:
                System.exit(0);

        }
    }

    public void loadFromFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = br.readLine()) != null) { /// đọc từng dòng từ buffered br , gán nội dung của dòng vừa đọc vào 'line', ktra xem dòng dọc còn giá trị ko, nếu dòng cuối cùng đã đc đọc thì 'readline()' sẽ trả về null, loop sẽ stop
                content.append(line).append("\n");
            }

            if (content.length() == 0) {
                System.out.println("File is empty");
                return;
            }

            System.out.println("Load from file successful!");

            // Lưu nội dung đã load vào biến instance
            loadedContent = content.toString();

            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("File not found " + fileName);
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
    }

    public void normalizeAndSave(String content) {
        // Kiểm tra xem đã load nội dung từ file chưa
        if (loadedContent == null || loadedContent.isEmpty()) {
            System.out.println("Please load content from a file first (Option 1)");
            return;
        }

        inOu.setOutputFile("output.txt"); // Thiết lập đường dẫn tới tệp tin output

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inOu.getOutputFile()))) {
            String[] lines = loadedContent.split("\n");

            for (String line : lines) {
                // Chuẩn hóa từng dòng và ghi vào file output
                line = OneSpace(line);
                line = SpecialCharacter(line);
                line = afterDot(line);
                line = noSpaceQuotes(line);
                line = firstUpercase(line);
                line = removeBlankLines(line);
                line = AddDotEnd(line);

                writer.write(line + "\n");
            }

            System.out.println("Content has been normalized and written to " + inOu.getOutputFile());
        } catch (IOException e) {
            System.err.println("Error writing to " + inOu.getOutputFile());
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

    public String removeBlankLines(String content) {
        StringBuilder result = new StringBuilder();

        String[] lines = content.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Kiểm tra xem dòng có trống không
            if (!line.isEmpty()) {
                result.append(line);

                // Nếu không phải dòng cuối cùng và dòng tiếp theo không trống, thêm dấu xuống dòng
                if (i < lines.length - 1 && !lines[i + 1].trim().isEmpty()) {
                    result.append("\n");
                }
            }
        }

        return result.toString();
    }

    public boolean isFileEmpty(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine() == null;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void checkNormalization() {
        // Kiểm tra xem đã load nội dung từ file chưa
        if (loadedContent == null || loadedContent.isEmpty()) {
            System.out.println("Please load content from a file first (Option 1)");
            return;
        }

        // Chuẩn hóa nội dung
        String normalizedContent = normalizeContent(loadedContent);

        // Kiểm tra xem nội dung đã được chuẩn hóa chưa
        if (normalizedContent.equals(loadedContent)) {
            System.out.println("The content is already normalized:");
            System.out.println(normalizedContent);
        } else {
            System.out.println("The content has not been normalized yet:");
            System.out.println(normalizedContent);
        }
    }

// Hàm chuẩn hóa nội dung
    private String normalizeContent(String content) {
        StringBuilder result = new StringBuilder();

        String[] lines = content.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Kiểm tra xem dòng có trống không
            if (!line.isEmpty()) {
                result.append(line);

                // Nếu không phải dòng cuối cùng và dòng tiếp theo không trống, thêm dấu xuống dòng
                if (i < lines.length - 1 && !lines[i + 1].trim().isEmpty()) {
                    result.append("\n");
                }
            }
        }

        return result.toString();
    }

}
