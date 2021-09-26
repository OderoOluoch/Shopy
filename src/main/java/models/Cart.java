package models;

public class Cart {
    private Item item;

    public Cart(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "item=" + item +
                '}';
    }
}
