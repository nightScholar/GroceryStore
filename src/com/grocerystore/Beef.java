package com.grocerystore;

/**
 * Beef grocery item implements Item methods
 */

public class Beef implements Item
{
    private String name = "Beef";
    private float price = 9.00f;


    /**
     * Empty constructor, no need to set name and price
     * values as they are already set upon object creation
     */

    public Beef()
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
