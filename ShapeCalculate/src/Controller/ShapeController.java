/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.library;
import Model.Shape;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.Menu;
import View.ViewShape;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class ShapeController extends Menu {

    Triangle t;
    Circle c;
    Rectangle r;
    ViewShape view;
    library input;

    public ShapeController() throws IOException {
        super("----------- Shape Calculator -----------", new String[]{"Calculate Triangle", "Calculate Circle", "Calculate Rectangle", "Exit"});
        input = new library();
        view = new ViewShape(input);
        c = new Circle();
        r = new Rectangle();
        t = new Triangle();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
                view.CalTriangle();
            case 2 ->
                view.CalCircle();
            case 3 ->    
                view.CalRectangle();
            case 4 ->
                System.exit(0);
        }
    }
    
    
}
