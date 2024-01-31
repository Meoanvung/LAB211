/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class BMI {

    public double height;
    public double weight;
    public double BMI;
    public BMIstatus status; //khai báo thuộc tính status có kiểu dữ liệu là BMIStatus để lưu trữ tình trạng BMI

    public BMI(double height, double weight, double BMI, BMIstatus status) {
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.status = status;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBMI() {
        return BMI;
    }

    public BMIstatus getStatus() {
        return status;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public void setStatus(BMIstatus status) {
        this.status = status;
    }
    
    // lưu trữ các trạng thái BMI
    public enum BMIstatus {
        UnderStandard,
        Standard,
        OverWeight,
        Fat,
        VeryFat
    }
    
    public void calculateBMI() {
        BMI = weight / (height * height);
    }

    // phương thức trả về tình trạng BMI
    public BMIstatus getBMIStatus() {
        if (BMI < 19) {
            status = BMIstatus.UnderStandard;
        } else if (BMI > 19 && BMI < 25) {
            status = BMIstatus.Standard;
        } else if (BMI >25 && BMI < 30) {
            status = BMIstatus.OverWeight;
        } else if (BMI > 30 && BMI < 40) {
            status = BMIstatus.Fat;
            System.out.println("Should lose weight");
        } else {
            status = BMIstatus.VeryFat;
            System.out.println("Should lose weight immediately");
        }
        return status;
    }
}
