import models.Catalog;
import models.Item;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Shopy, ");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("AVAILABLE ITEMS IN THE CATALOG: ");
        System.out.println("1. Item: Kabras Sugar Qty: 10");
        System.out.println("2. Item: Ajab Flour Qty: 10");
        System.out.println("3. Item: Kimbo Oil Qty: 8");
        System.out.println("");
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("PLEASE SELECT ANY OF THE FOLLOWING TO ENJOY OUR SERVICES ");
        System.out.println("1. Place an Order");
        System.out.println("2. Cancel the Order");
        System.out.println("3. View Cart");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");
        System.out.println("6. Please choose option: 1");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch(num) {
            case 1:
                System.out.println("We are placing an order");
                break;
            case 2:
                System.out.println("We are cancelling an order");
                break;
            case 3:
                System.out.println("We are viewing the cart");
                break;
            case 4:
                System.out.println("We are viewing the order");
                break;
            case 5:
                System.out.println("We want to exit");
                break;
            default:
                System.out.println("Alaaaa");
        }


    }

    public void populateItems(){
        Item item = new Item(1,"Kabras Sugar", 15);
        Catalog catalog = new Catalog(1,item);
        catalog.getItemQty(item);
    }

}
