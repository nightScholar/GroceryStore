package com.grocerystore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Item test class
 */


public class ItemTest
{
    /**
     * Created all classes that implement Item interface
     */
    private Item beef = new Beef();
    private Item chicken = new Chicken();
    private Item bread = new Bread();
    private Item cereal = new Cereal();
    private Item eggs = new Eggs();
    private Item milk = new Milk();
    private Item oatmeal = new Oatmeal();


    /**
     * Test getName method
     */

    @Test
    public void getItemName()
    {
        assertEquals("Beef", beef.getItemName());
        assertEquals("Chicken", chicken.getItemName());
        assertEquals("Bread", bread.getItemName());
        assertEquals("Cereal", cereal.getItemName());
        assertEquals("Eggs", eggs.getItemName());
        assertEquals("Milk", milk.getItemName());
        assertEquals("Oatmeal", oatmeal.getItemName());
    }

    /**
     * Test getPrice method
     */

    @Test
    public void getPrice()
    {
        assertTrue(beef.getPrice() == 9.00f);
        assertTrue(chicken.getPrice() == 6.00f);
        assertTrue(bread.getPrice() == 3.50f);
        assertTrue(cereal.getPrice() == 4.00f);
        assertTrue(eggs.getPrice() == 2.50f);
        assertTrue(milk.getPrice() == 3.50f);
        assertTrue(oatmeal.getPrice() == 2.00f);
    }
}