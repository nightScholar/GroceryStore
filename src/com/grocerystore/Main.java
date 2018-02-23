package com.grocerystore;

public class Main
{

    public static void main(String[] args)
    {
        //Program demonstration 1

        //Creating database, customer, and shopping cart objects
        Database database = new Database("Trader Joe's");
        Customer customer = new Customer("Max", false, true);
        ShoppingCart shoppingCart = new ShoppingCart("Max's Cart", database);

        //Adding items to shopping cart
        shoppingCart.addGroceryToCart("Milk", 6);
        shoppingCart.addGroceryToCart("Cereal", 8);
        shoppingCart.addGroceryToCart("Oatmeal", 6);
        shoppingCart.addGroceryToCart("Eggs", 5);
        shoppingCart.addGroceryToCart("Beef", 7);
        shoppingCart.addGroceryToCart("Bread", 10);

        //Calculating the price of the items in the cart
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);


        //Program demonstration 2
        ShoppingCart shoppingCart1 = new ShoppingCart("Eric's Cart", database);
        Customer customer1 = new Customer("Eric", true, true);

        shoppingCart1.addGroceryToCart("Milk", 51);

        shoppingCart1.calcPurchasePrice(shoppingCart1.getGroceryList(), customer1);


    }
}
