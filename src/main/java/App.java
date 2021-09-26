import Services.Cart;
import Services.Catalogue;
import models.ShopItem;

import java.util.Scanner;

public class App {
    private static Catalogue itemsInStock = new Catalogue();
    static Cart cart = new Cart();
    public static void main(String[] args) {
        generateStock();
        System.out.println("Welcome to Shopy, ");
        System.out.println("--------------------------------------------");
        show();
    }

    public static void show(){
        System.out.println(itemsInStock);
        System.out.println("--------------------------------------------");
        System.out.println("PLEASE SELECT ANY OF THE FOLLOWING TO ENJOY OUR SERVICES ");
        System.out.println("Enter 1 to Place an Order");
        System.out.println("Enter 2 to View Cart");
        System.out.println("Enter 3 to View Orders");
        System.out.println("Enter 4 to Exit");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch(num) {
            case 1:
                makeAnOrder();
                break;
            case 2:
                viewCart();
                break;
            case 3:
                System.out.println("We are viewing the order");
                break;
            case 4:
               exit();
                break;
            default:

        }
    }

    private static void viewCart() {
        Scanner scan = new Scanner(System.in);
        if(cart != null){
            System.out.println(cart);
        }else {
            System.out.println("Your cart is empty");
        }

        System.out.println("***********************************************");

        System.out.println("Enter 1 to confirm order placement");
        System.out.println("Enter 2 to purchase more items");
        System.out.println("Enter 3 to remove an item from the cart");
        System.out.println("Enter 4 to exit");
        int num = scan.nextInt();
        switch(num) {
            case 1:
                System.out.println("We are happy to serve you. Your order is on the way and will be paid on delivery");
                System.out.println("************************Order details***********************");
                System.out.println(cart);
                break;
            case 2:
                makeAnOrder();
                break;
            case 3:
                removeFromCart();
                break;
            case 4:
                System.out.println("Exit");
            default:
                System.out.println("Alaaaa");
        }

    }

    private static void removeFromCart() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the item you want to remove _________");
        String itemName = scan.nextLine();
        System.out.println("How Many of " + itemName + " had you ordered  _________");
        int itemQuantity = scan.nextInt();

        ShopItem shopItem = itemsInStock.get(itemName);
        if(shopItem == null ){
            System.out.println("Sorry, we do not have " + itemName + " in your current shopping cart");
        }
        if(itemsInStock.sellItem(itemName,itemQuantity) !=0){
            cart.removeItemFromCart(shopItem,itemQuantity);

        }

        System.out.println("Please make the following selections to proceed");
        System.out.println("Enter 1 to View Cart");
        System.out.println("Enter 2 to Continue Shopping");
        System.out.println("Enter 3 to Exit");
        int num = scan.nextInt();
        switch(num) {
            case 1:
                viewCart();
                break;
            case 2:
                makeAnOrder();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Alaaaa");
        }


    }

    public static void generateStock(){
        ShopItem shopItem = new ShopItem("Supa Loaf", 50.00, 100);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Maziwa Mala", 100.00, 10);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Rhino Kiberiti", 5.00, 12);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Queen cake", 20.00, 5);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Queen cake", 20.00, 4);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Pishori rice", 85.00, 13);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Kabras Sugar", 90.00, 20);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Mumias Sugar", 85.0, 17);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Royco cubes", 6.0, 9);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Britania Biscuits", 5.0, 25);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Kasuku book", 50.5, 3);
        itemsInStock.addStockToCatalogue(shopItem);

        shopItem = new ShopItem("Cocoa", 5.00, 11);
        itemsInStock.addStockToCatalogue(shopItem);
    }

    public static void makeAnOrder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to order _________");
        String itemName = scan.nextLine();
        System.out.println("How Many of " + itemName + " would ou like to order _________");
        int itemQuantity = scan.nextInt();


        sellItem(cart,itemName,itemQuantity);

        System.out.println("Please make the following selections to proceed");
        System.out.println("Enter 1 to View Cart");
        System.out.println("Enter 2 to Continue Shopping");
        System.out.println("Enter 3 to Exit");
        int num = scan.nextInt();
        switch(num) {
            case 1:
                viewCart();
                break;
            case 2:
                makeAnOrder();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Alaaaa");
        }


    }

    public static int sellItem(Cart cart, String itemName, int quantity){
        //User the given name to search for the item from the items available in the catalogue
        ShopItem shopItem = itemsInStock.get(itemName);
        if(shopItem == null ){
            System.out.println("Sorry, we do not have " + itemName + " at the moment. Please check back later");
            return 0;
        }else if(quantity > shopItem.getQuantityInStock()){
            System.out.println("We only have " + shopItem.getQuantityInStock() +" available for " + shopItem.getName());
        }
        if(itemsInStock.sellItem(itemName,quantity) !=0){
            cart.addItemToCart(shopItem,quantity);
            return quantity;
        }
        return 0;
    }
    public static void exit(){
        System.out.println("Thank you for Shopping with us");
        System.exit(0);
    }
}
