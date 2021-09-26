package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemTest {

    Item testItem;

    @BeforeEach
    public void setUp(){
        testItem = new Item("Kiwi",70.00,20);
    }

    @Test
    @DisplayName("Should create Shop Item Object")
    public void item_shouldCreateItemObject_true(){
        assertEquals(true, testItem instanceof  Item);
    }

    @Test
    @DisplayName("Should fetch the name of the shop item")
    public void getName_itemInstantiatesWithName_Kiwi(){
        assertEquals("Kiwi", testItem.getName());
    }

    @Test
    @DisplayName("Should fetch the price of the shop item")
    public void getPrice_itemInstantiatesWithPrice_Kiwi(){
        assertEquals(70.00, testItem.getPrice());
    }

    @Test
    @DisplayName("Should fetch the quanity of the shop item")
    public void getQuantity_itemInstantiatesWithQuantity_Kiwi(){
        assertEquals(20, testItem.getQuantityInStock());
    }

    @ParameterizedTest
    @DisplayName("Should correctly adjust the price of the shop item")
    @ValueSource(doubles = { 25.00 })
    public void setPrice_setsItemPrice_25(Double price){
        testItem.setPrice(price);
        assertEquals(25.00, testItem.getPrice());
    }

    @ParameterizedTest
    @DisplayName("Returns current price if price is set to zero")
    @ValueSource(doubles = { 00.00 })
    public void setPrice_setsItemPriceToZero_75(Double price){
        testItem.setPrice(price);
        assertEquals(70, testItem.getPrice());
    }


    @ParameterizedTest
    @DisplayName("Returns new quantity in stock if stock number is changed")
    @ValueSource(ints = { 5 })
    public void adjustStock_IncreaseStockNumber_25(Integer addedStock){
        testItem.manageStock(addedStock);
        assertEquals(25, testItem.getQuantityInStock());
    }

    @ParameterizedTest
    @DisplayName("Returns existing stock number if stock number is changed by a zero")
    @ValueSource(ints = { 0 })
    public void adjustStock_IncreaseStockNumberWithZero_25(Integer addedStock){
        testItem.manageStock(addedStock);
        assertEquals(20, testItem.getQuantityInStock());
    }

    @Test
    @DisplayName("Should return true if the object name is true")
    public void equals_returnsTrueIfNameIsSame_True(){
        Item testItemTwo = new Item("Kiwi",70.00,20);
        assertTrue(testItem.equals(testItemTwo));
    }



}