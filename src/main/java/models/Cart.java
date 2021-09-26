package models;

public class Cart {
    private ShopItem item;

    public Cart(ShopItem item) {
        this.item = item;
    }

    public ShopItem getItem() {
        return item;
    }

    public void setItem(ShopItem item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "item=" + item +
                '}';
    }
}
