package Services;

import models.ShopItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalogueTest {
    ShopItem testItem;
    private static Catalogue shopCatalogue;

    @BeforeEach
    public void setUp(){
        testItem = new ShopItem("Royco",70.00,20);
        shopCatalogue = new Catalogue();
    }

    @Test
    @DisplayName("Should instantiate shop catalogue item correctly")
    public void shopCatalogue_shouldCreateCatalogueObject_true(){
        assertEquals(true, shopCatalogue instanceof Catalogue);
    }

    @Test
    @DisplayName("Should add item to the shop catalogue")
    public void item_addItemToCatalogue_true(){
        shopCatalogue.addStockToCatalogues(testItem);
        assertEquals(testItem,shopCatalogue.get(testItem.getName()) );
    }


}