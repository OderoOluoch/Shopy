package models;

public class Item {
    private final String name;
    private double price;
    private int quantityInStock = 0;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public Item(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
        }
    }

    public void manageStock(int quantity){
        int adjustedQuantity = this.quantityInStock + quantity;
        if(adjustedQuantity >= 0){
            this.quantityInStock = adjustedQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }
        String objName = ((Item) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }

}
