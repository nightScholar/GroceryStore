package com.grocerystore;

/**
 * Chicken grocery item implements Item methods
 */


public class Chicken implements Item
{
    private String name = "Chicken";
    private float price = 6.00f;

    /**
     * Empty constructor, no need to set name and price
     * values as they are already set upon object creation
     */

    public Chicken()
    {

    }

    /**
     * Get the value of name member variable
     */
    @Override
    public String getItemName()
    {
        return this.name;
    }

    /**
     * Get the value of price member variable
     */
    @Override
    public float getPrice()
    {
        return this.price;
    }
}
