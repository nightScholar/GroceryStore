package com.grocerystore;

/**
 * Cereal grocery item implements Item methods
 */


public class Cereal implements Item
{
    private String name = "Cereal";
    private float price = 4.00f;

    /**
     * Empty constructor, no need to set name and price
     * values as they are already set upon object creation
     */

    public Cereal()
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
