package com.grocerystore;

/**
 * Milk grocery item implements Item methods
 */


public class Milk implements Item
{
    private String name = "Milk";
    private float price = 3.50f;

    /**
     * Empty constructor, no need to set name and price
     * values as they are already set upon object creation
     */

    public Milk()
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
