/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Inputter;
import Model.Order;
import Model.fruit;
import View.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class FruitShopManagement extends Menu {

    static String[] choice = {"Creat fruit", "View orders", "Shopping (for buyer)", "Exit"};
    Inputter input;
    ArrayList<fruit> list_F;
    fruit f;
    Order o;
    Hashtable<String, ArrayList<Order>> list_O, ht = new Hashtable<>();

    public FruitShopManagement() {
        super("Wellcome to fruit shop", choice);
        input = new Inputter();
        list_F = new ArrayList<>();
        f = new fruit();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createFruit(list_F);
                break;
            case 2:
                ViewOrder(ht);
                break;
            case 3:
                Shopping(list_F, ht);
                break;
            case 4:
                System.exit(0);

        }
    }

    public void createFruit(ArrayList<fruit> list_F) {
        do {
            int id = generateID(list_F);
            String name = input.inputPattern("Enter fruit's name: ");
            int quantity = input.getIntFromInput("Enter fruit's quantity: ");
            double price = input.getDouble("Enter the fruit's price: ");
            String origin = input.inputPattern("Enter the fruit's origin: ");
            list_F.add(new fruit(id, name, price, quantity, origin));
            System.out.println("Create fruit successfuly!");

        } while (input.shouldContinue("Do you want to continue"));
        DisplayFruittList(list_F);
    }

    public void DisplayFruittList(ArrayList<fruit> list_F) {
        if (list_F.isEmpty()) {
            System.out.println("The list fruit is empty, please create first");
        } else {
            System.out.printf("| %-10s | %-15s | %-5s | %-10s | %-10s%n", "++ id ++", "++ Fruit Name ++", "++ Price ++", "++ Quantity ++", "++ Origin ++");
            System.out.println("-----------------------------------------------------------------------------");
            for (fruit f : list_F) {
                System.out.printf("| %-10s | %-16s | %-11s | %-14s | %-10s%n", f.getId(), f.getName(), f.getPrice() + "$", f.getQuantity(), f.getOrigin());
            }
        }
    }

    public void ViewOrder(Hashtable<String, ArrayList<Order>> ht) {
        if (ht == null) {
            System.out.println("No order!");
            return;
        }
        for (String name : ht.keySet()) {
            System.out.println("Cusomer: " + name);
            ArrayList<Order> array_o = ht.get(name);
            DisplayOrdertList(array_o);
        }
    }

    public void Shopping(ArrayList<fruit> list_F, Hashtable<String, ArrayList<Order>> ht) {
        DisplayFruittList(list_F);
        String name = input.inputPattern("Enter fruit's name: ");
        ArrayList<Order> list_O = new ArrayList<>();

        // Tìm trái cây trong danh sách dựa trên tên
        fruit selectedFruit = null;
        for (fruit f : list_F) {
            if (name.equals(f.getName())) {
                selectedFruit = f;
                break;
            }
        }

        if (selectedFruit != null) {
            System.out.println("You selected: " + selectedFruit.getName());

            // Yêu cầu người dùng nhập số lượng cần mua
            int quantityToBuy = input.getIntFromInput("Please input quantity to buy: ");

            // Kiểm tra số lượng hợp lệ
            if (quantityToBuy > 0 && quantityToBuy <= selectedFruit.getQuantity()) {
                // Thêm đơn hàng mới vào danh sách đơn hàng
                list_O.add(new Order(selectedFruit.getId(), selectedFruit.getName(),
                        selectedFruit.getPrice(), quantityToBuy));

                // Cập nhật số lượng còn lại của trái cây
                selectedFruit.setQuantity(selectedFruit.getQuantity() - quantityToBuy);

                // Hiển thị thông tin đơn hàng vừa mua
                DisplayOrdertList(list_O);

                // Yêu cầu người dùng nhập tên để hoàn tất đơn hàng
                String customer = input.inputPattern("Enter customer's name: ");
                ht.put(customer, list_O);

                System.out.println("Shopping successfully!!");
            } else {
                System.out.println("Invalid quantity or not enough in stock.");
            }
        } else {
            System.out.println("Fruit not found.");
        }
    }

    public void DisplayOrdertList(ArrayList<Order> list_O) {
        double total = 0;
        if (list_O.isEmpty()) {
            System.out.println("You are not still shopping from fruit's list!");
        } else {
            System.out.printf("| %-10s | %-10s | %-5s | %-10s%n", "++ id ++", "++ Name ++", "++ Price ++", "++ Quantity ++");
            System.out.println("---------------------------------------------------------");
            for (Order o : list_O) {
                System.out.printf("| %-10s | %-10s | %-11s | %-15s%n", o.getId(), o.getName(), o.getPrice() + "$", o.getQuantity());
                total += o.getPrice() * o.getQuantity();
            }
            System.out.println("Total: " + total);
        }
    }

    public int generateID(ArrayList<fruit> list_F) {
        Random random = new Random();
        int newID;

        // Loop to ensure ID is unique
        do {
            newID = random.nextInt(1000);
        } while (!isIDUnique(newID, list_F));

        return newID;
    }

    public boolean isIDUnique(int newID, ArrayList<fruit> list_F) {
        for (fruit f : list_F) {
            if (f.getId() == newID) {
                return false; // ID already exists, not unique
            }
        }
        return true; // ID is unique

    }
}
