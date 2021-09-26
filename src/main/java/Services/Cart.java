package Services;

import models.ShopItem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
   private final Map<ShopItem, Integer> itemsInStock;

    public Cart() {
        this.itemsInStock = new HashMap<>();
    }

    public int addItemToCart(ShopItem shopItem, int quantity){
        if( (shopItem != null ) && (quantity > 0)){
            int inCart = itemsInStock.getOrDefault(shopItem,0);
            itemsInStock.put(shopItem, inCart + quantity);
            return inCart;
        }
        return 0;
    }

    public int removeItemFromCart(ShopItem shopItem, int quantity){
        if( (shopItem != null ) && (quantity > 0)){
            int inCart = itemsInStock.getOrDefault(shopItem,0);
            itemsInStock.put(shopItem,inCart -quantity);
            itemsInStock.remove(shopItem);
            return inCart;
        }
        return 0;
    }

    public Map<ShopItem, Integer> ItemsInCart(){
        return Collections.unmodifiableMap(itemsInStock);
    }

    @Override
    public String toString(){
        String s = "\nShopping Cart contains " + itemsInStock.size() + ((itemsInStock.size() ==1) ? " item" : " items" ) + "\n";
        double totalCost = 0.00;
        for (Map.Entry<ShopItem, Integer> shopItem : itemsInStock.entrySet()){
            s = s + shopItem.getKey() + ". " + shopItem.getValue() + " in our shopping cart\n";
            totalCost += shopItem.getKey().getPrice() * shopItem.getValue();
        }
        return  s + "Total cost " + totalCost;
    }
}
