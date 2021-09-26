package Services;

import models.ShopItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Catalogue {
    private  final Map<String, ShopItem> itemsInStock;

    public Catalogue() {
        this.itemsInStock = new LinkedHashMap<>();
    }

    public int addStockToCatalogues(ShopItem shopItem){
        if(shopItem != null){
            //Check if item already exists in the catalogue
            ShopItem inStock = itemsInStock.getOrDefault(shopItem.getName(),shopItem);
            //if the item already exits, then we only change the quantity
            if(inStock != shopItem){
                shopItem.manageStock(inStock.getQuantityInStock());
            }
            itemsInStock.put(shopItem.getName(),inStock);
            return shopItem.getQuantityInStock();
        }
        return 0;
    }



    public ShopItem get(String key){
        return itemsInStock.get(key);
    }

    @Override
    public String toString(){
        String s = "\nShop Catalogue\n";
        double totalCost = 0.00;
        for(Map.Entry<String, ShopItem> catalogueItem : itemsInStock.entrySet()){
            ShopItem shopItem = catalogueItem.getValue();

            double itemValue = shopItem.getPrice() * shopItem.getQuantityInStock();
            s = s + shopItem + ". Available Quantity " +shopItem.getQuantityInStock();
        }
        return s ;
    }


}
