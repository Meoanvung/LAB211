/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Common.library;
import Model.Shape;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ViewShape {

    private Circle c = new Circle();
    private Rectangle r = new Rectangle();
    private Triangle t = new Triangle();
    library input;

    public ViewShape() {
        c = new Circle();
        r = new Rectangle();
        t = new Triangle();
    }

    public ViewShape(library input) {
        this();
        this.input = input;
    }

    public void CalTriangle() {
        double sideA = input.getdoubleFromInput("Enter number of side A: ");
        double sideB = input.getdoubleFromInput("Enter number of side B: ");
        double sideC = input.getdoubleFromInput("Enter number of side C: ");
        Triangle t = new Triangle(sideA, sideB, sideC);
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        t.printResult();
    }
    
    public void CalRectangle(){
        double width = input.getdoubleFromInput("Enter the width: ");
        double length = input.getdoubleFromInput("Enter the length: ");
        Rectangle r = new Rectangle(width, length);
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        r.printResult();
    }
    
    public void CalCircle(){
    double radius = input.getdoubleFromInput("Enter radius: ");
    Circle c = new Circle(radius);
    System.out.println("-----Radius-----");
    System.out.println("Radius : " + radius);
    c.printResult();
    }
}
