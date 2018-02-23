package com.grocerystore;

import java.util.ArrayList;

/**
 * Shopping Cart class serves as main driver for
 * grocery application
 */

public class ShoppingCart
{
    private String name;
    private Database database;
    private ArrayList<String> groceryList = new ArrayList<>(50);
    private float fivePercentDiscount = 0.05f;
    private float tenPercentDiscount = 0.10f;
    private float salesTax = 0.045f;
    private float total = 0.0f;

    public ShoppingCart(String name, Database database)
    {
        this.name = name;
        this.database = database;
    }


    /**
     * Calculating the price of items in shopping cart and applying
     * the correct discounts based on the size of the shopping cart
     * string array, if the customer has tax exempt status, and if
     * the customer is a store member or not. All values are rounded
     * to two places past the decimal point (i.e., $0.00)
     */
    public void calcPurchasePrice(ArrayList<String> productIDs, Customer customer)
    {

        for(String productID : productIDs)
        {
            Item item = database.getItem(productID);

            if(item != null)
            {
                this.total += item.getPrice();
            }
            else
            {
                System.out.println("No matching items found");
            }
        }
        if (groceryList.size() >= 10 && groceryList.size() < 51)
        {
            float difference = Math.round((total * tenPercentDiscount) * 100.0f) / 100.0f;
            total = Math.round((total - difference) * 100.0f) / 100.0f;

            System.out.println("-A ten percent discount has been applied " +
                    "based on your cart size");
        }
        else if (groceryList.size() > 5 && groceryList.size() < 10)
        {
            float difference = Math.round((total * fivePercentDiscount) * 100.0f) / 100.0f;
            total = Math.round((total - difference) * 100.0f) / 100.0f;

            System.out.println("-A five percent discount has been applied" +
                    " based on your cart size");
        }
        else
        {
            System.out.println("-No discount has been applied based on" +
                    " the number of items you have in your cart");
        }
        if(customer.isStoreMember() == true)
        {
            float difference = Math.round((total * tenPercentDiscount) * 100.0f) / 100.0f;
            total = Math.round((total - difference) * 100.0f) / 100.0f;

            System.out.println("-An additional 10% off has been" +
                    " applied for being a store member");
        }
        else
        {
            System.out.println("-Only store members get " +
                    "an additional 10% off");
        }
        if (customer.isTaxExempt() == true)
        {
            System.out.println("-Your tax exempt status has been applied\n");
            printTotal();
            System.out.println();
        }
        else if(customer.isTaxExempt() == false && groceryList.size() >= 51)
        {
            System.out.println("-Shopping cart cannot hold more than " +
                    "50 items at a time. Please remove " +
                    "at least one item in order to calculate your total\n");
            total = 0.00f;
            printTotal();
            System.out.println();
        }
        else
        {
            float difference = Math.round((total * salesTax) * 100.0f) / 100.0f;
            total = Math.round((total + difference) * 100.0f) / 100.0f;

            System.out.println("-You do not have tax exempt status\n");
            printTotal();
            System.out.println(" after sales tax\n");
        }

    }


    /**
     * Print total price to console
     */
    public void printTotal()
    {
        System.out.print("Your total price is $" + getTotal());
    }

    /**
     * Adding grocery items to member variable
     * groceryList
     */

    public void addGroceryToCart(String item, int quantity)
    {
        try
        {
            if (quantity < 0 || quantity == 0)
            {
                throw new IllegalStateException();
            }
            else if(quantity >= 51)
            {
                throw new IllegalStateException();
            }
            else
            {
                for(int i = 0; i < quantity; i++)
                {
                    groceryList.add(item);
                }
            }
        }
        catch (IllegalStateException exception)
        {
            System.out.println("-Cannot add a quantity of " +
                    quantity + " " + item + " items to shopping cart");
        }
    }

    /**
     * Returns the price of the items in the shopping cart rounded
     * to the nearest $0.01
     */
    public float getTotal()
    {
        return Math.round(this.total * 1000.0f) / 1000.0f;
    }

    /**
     * Returns the grocery list of the shopping cart object
     */
    public ArrayList<String> getGroceryList()
    {
        return this.groceryList;
    }

    /**
     * Returns the name of the shopping cart
     * member variable
     */
    public String getName()
    {
        return this.name;
    }
}
