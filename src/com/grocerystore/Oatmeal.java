package com.grocerystore;

/**
 * Oatmeal grocery item implements Item methods
 */

public class Oatmeal implements Item
{
    private String name = "Oatmeal";
    private float price = 2.00f;

    /**
     * Empty constructor, no need to set name and price
     * values as they are already set upon object creation
     */

    public Oatmeal()
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
