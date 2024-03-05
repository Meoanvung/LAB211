/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.Validation;
import Model.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ViewDataFomat {
    Validation v;
    
    public ViewDataFomat() {
        v = new Validation();
    }
    public Data getDataFromInput() {
        int phoneNumber;
        String email, dateStr;
        
        phoneNumber = Integer.parseInt(v.checkPhone("Enter phone number: "));
        email = v.checkEmail("Enter email: ");
        dateStr = v.checkDate("Enter date (dd/MM/yyyy): ");

        // Chuyển đổi ngày từ chuỗi sang đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            // Xử lý nếu không thể chuyển đổi định dạng ngày
            e.printStackTrace();
            date = null;
        }

        // Trả về đối tượng Data mới với dữ liệu đã nhập
        return new Data(phoneNumber, email, date);
    }
}
