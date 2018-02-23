package com.grocerystore;

/**
 * Eggs grocery item implements Item methods
 */


public class Eggs implements Item
{
    private String name = "Eggs";
    private float price = 2.50f;

    /**
     * Empty constructor, no need to set name and price
     * values as they are already set upon object creation
     */

    public Eggs()
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
