package Services;

import models.ShopItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {
    ShopItem testItem;
    Cart cart;
    private static Catalogue shopCatalogue;
    private Map<ShopItem, Integer> itemsInStock;

    @BeforeEach
    public void setUp(){
        testItem = new ShopItem("Royco",70.00,20);
        shopCatalogue = new Catalogue();
        cart = new Cart();
        this.itemsInStock = new HashMap<>();
    }

    @Test
    @DisplayName("Should instantiate Cart object correctly")
    public void shopCatalogue_shouldCreateCatalogueObject_true(){
        assertEquals(true, cart instanceof Cart);
    }

    @Test
    @DisplayName("Should add item to cart")
    public void item_addItemToCart_true(){
        cart.addItemToCart(testItem,1);
        assertEquals(1,cart.ItemsInCart().size());
    }

}