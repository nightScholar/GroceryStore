package com.grocerystore;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Shopping Cart test class
 */
public class ShoppingCartTest
{
    /**
     * Creating Database, Customer, and String grocery list for
     * shopping cart object
     */
    private Database database = new Database("Acme");
    private ShoppingCart shoppingCart = new ShoppingCart("Michael's Cart", database);


    /*The following tests outline full branch coverage for the calculate
    * purchase price method*/

    /**
     * Testing that a discount of
     * 10% is applied based on cart size ranging from
     * 10 to 50 items
     */
    @Test
    public void cartSizeTenOrMore()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 50);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(423.23f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of 5%
     * is applied to a cart size greater than five
     * but less than ten items
     */
    @Test public void cartSizeGreaterThanFive()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 6);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(53.61f, shoppingCart.getTotal());
    }

    /**
     * Testing that no discount is applied based
     * on the size of the shopping cart of five items
     */
    @Test
    public void noDiscountFiveItems()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 5);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(47.03f, shoppingCart.getTotal());
    }

    /**
     * Testing that no discount is applied based
     * on the size of the shopping cart of
     * fewer than five items
     */
    @Test
    public void noDiscountLessThanFive()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 4);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(37.62f, shoppingCart.getTotal());
    }

    /**
     * Testing that a 10% discount is applied for
     * a customer based on the size of their cart
     * and receives an additional 10% discount due to being
     * a store member
     */
    @Test
    public void isStoreMemberTen()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, true);

        shoppingCart.addGroceryToCart(beef, 10);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(76.18f, shoppingCart.getTotal());
    }


    /**
     * Testing that a 5% discount is applied for
     * a customer based on the size of their cart
     * and receives an additional 10% discount due to being
     * a store member
     */
    @Test
    public void isStoreMemberFive()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, true);

        shoppingCart.addGroceryToCart(beef, 6);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(48.25f, shoppingCart.getTotal());
    }

    /**
     * Testing that no discount is applied for
     * a customer based on the size of their cart
     * and receives a 10% discount due to being
     * a store member
     */
    @Test
    public void isStoreMemberFour()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, true);

        shoppingCart.addGroceryToCart(beef, 4);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(33.86f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of 10% is applied for
     * a customer based on the size of their cart and does
     * not receive a store member discount
     */
    @Test
    public void notStoreMemberTen()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 11);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(93.11f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of 5% is applied for
     * a customer based on the size of their cart and does
     * not receive a store member discount
     */
    @Test
    public void notStoreMemberFive()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 6);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(53.61f, shoppingCart.getTotal());
    }

    /**
     * Testing that no discount is applied for
     * a customer based on the size of their cart
     * and does not receive a store member discount
     */
    @Test
    public void notStoreMemberFour()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 4);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(37.62f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of 10% is applied for
     * a customer based on the size of their cart and does
     * not receive a store member discount,
     * and will not pay sales tax because they are
     * tax exempt
     */
    @Test
    public void isTaxExemptTen()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", true, false);

        shoppingCart.addGroceryToCart(beef, 10);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(81.00f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of 5% is applied for
     * a customer based on the size of their cart, does
     * not receive a store member discount,
     * and will not pay sales tax because they are
     * tax exempt
     */
    @Test
    public void isTaxExemptFive()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", true, false);

        shoppingCart.addGroceryToCart(beef, 6);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(51.30f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of is not applied for
     * a customer based on the size of their cart, does
     * not receive a store member discount,
     * and will not pay sales tax because they are
     * tax exempt
     */
    @Test
    public void isTaxExemptFour()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", true, false);

        shoppingCart.addGroceryToCart(beef, 4);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(36.00f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of 10% is applied based
     * on the size of the cart, does not receive a
     * store member discount, and pays sales
     * tax because they are not tax exempt.
     */
    @Test
    public void isNotTaxExemptTen()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 10);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(84.65f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount of 5% is applied based
     * on the size of the cart, does not receive a
     * store member discount, and pays sales
     * tax because they are not tax exempt.
     */
    @Test
    public void isNotTaxExemptFive()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 6);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(53.61f, shoppingCart.getTotal());
    }

    /**
     * Testing that a discount is not applied based
     * on the size of the cart, does not receive a
     * store member discount, and pays sales
     * tax because they are not tax exempt.
     */
    @Test
    public void isNotTaxExemptFour()
    {
        String beef = "Beef";
        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef, 4);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(37.62f, shoppingCart.getTotal());
    }

    /*End branch testing for calculate purchase price method*/

    //Begin Equivalence partition testing

    /**
     * This will test the equivalence partition
     * of [0,5] with 3 grocery
     * items in the cart
     */
    @Test
    public void threeItems()
    {
        String beef = "Beef";
        String chicken = "Chicken";
        String eggs = "Eggs";

        Customer customer = new Customer("Tom", false, false);

        shoppingCart.addGroceryToCart(beef,1 );
        shoppingCart.addGroceryToCart(chicken, 1);
        shoppingCart.addGroceryToCart(eggs, 1);

        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(18.29f, shoppingCart.getTotal());
    }

    /**
     * This will test the equivalence partition
     * of [5,10] with 7 grocery
     * items in the cart
     */
    @Test
    public void sevenItems()
    {
        Customer customer = new Customer("Tom", false, false);

        String beef = "Beef";
        String chicken = "Chicken";
        String eggs = "Eggs";
        String bread = "Bread";
        String cereal = "Cereal";
        String milk = "Milk";
        String oatmeal = "Oatmeal";

        shoppingCart.addGroceryToCart(beef, 1);
        shoppingCart.addGroceryToCart(chicken, 1);
        shoppingCart.addGroceryToCart(eggs, 1);
        shoppingCart.addGroceryToCart(bread, 1);
        shoppingCart.addGroceryToCart(cereal, 1);
        shoppingCart.addGroceryToCart(milk, 1);
        shoppingCart.addGroceryToCart(oatmeal,1 );

        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(30.27f, shoppingCart.getTotal());
    }

    /**
     * This will test the equivalence partition
     * of [10,50] with 35 grocery
     * items in the cart
     */
    @Test public void thirtyFiveItems()
    {
        Customer customer = new Customer("Tom", false, false);

        String eggs = "Eggs";

        shoppingCart.addGroceryToCart(eggs, 35);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(82.29f, shoppingCart.getTotal());
    }

    //Begin Boundary Value Analysis

    /**
     * This will test the boundary value analysis
     * with values [0,1] in the cart, which will
     * test the first Equivalence partition
     */
    @Test
    public void boundaryValue1()
    {
        Customer customer = new Customer("Tom", false, false);
        ShoppingCart shoppingCart1 = new ShoppingCart("Eric", database);

        String milk = "Milk";

        shoppingCart.addGroceryToCart(milk, 0);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(0.00f, shoppingCart.getTotal());

        shoppingCart1.addGroceryToCart(milk, 1);
        shoppingCart1.calcPurchasePrice(shoppingCart1.getGroceryList(), customer);

        assertEquals(3.66f, shoppingCart1.getTotal());
    }

    /**
     * This will test the boundary value analysis
     * with values [4,5,6] in the cart, which will test
     * the left edge of the second Equivalence partition
     */
    @Test
    public void boundaryValue2()
    {
        Customer customer = new Customer("Tom", false, false);
        String milk = "Milk";

        shoppingCart.addGroceryToCart(milk, 4);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(14.63f, shoppingCart.getTotal());

        ShoppingCart shoppingCart1 = new ShoppingCart("Eric", database);
        shoppingCart1.addGroceryToCart(milk, 5);
        shoppingCart1.calcPurchasePrice(shoppingCart1.getGroceryList(), customer);

        assertEquals(18.29f, shoppingCart1.getTotal());

        ShoppingCart shoppingCart2 = new ShoppingCart("Thomas", database);
        shoppingCart2.addGroceryToCart(milk, 6);
        shoppingCart2.calcPurchasePrice(shoppingCart2.getGroceryList(), customer);

        assertEquals(20.85f, shoppingCart2.getTotal());

    }

    /**
     * This will test the boundary value analysis
     * with values [9,10,11] in the cart, which will test
     * the right edge of the second Equivalence partition
     * and the left edge of the third Equivalence partition
     */
    @Test
    public void boundaryValue3()
    {
        Customer customer = new Customer("Tom", false, false);
        String milk = "Milk";

        shoppingCart.addGroceryToCart(milk, 9);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(31.27f, shoppingCart.getTotal());

        ShoppingCart shoppingCart1 = new ShoppingCart("Eric", database);
        shoppingCart1.addGroceryToCart(milk, 10);
        shoppingCart1.calcPurchasePrice(shoppingCart1.getGroceryList(), customer);

        assertEquals(32.92f, shoppingCart1.getTotal());

        ShoppingCart shoppingCart2 = new ShoppingCart("Thomas", database);
        shoppingCart2.addGroceryToCart(milk, 11);
        shoppingCart2.calcPurchasePrice(shoppingCart2.getGroceryList(), customer);

        assertEquals(36.21f, shoppingCart2.getTotal());

    }

    /**
     * This will test the boundary value analysis
     * with values [49,50,51] in the cart, which will
     * test the right edge of the last Equivalence partition
     */
    @Test
    public void boundaryValue4()
    {
        Customer customer = new Customer("Tom", false, false);
        String milk = "Milk";

        shoppingCart.addGroceryToCart(milk, 49);
        shoppingCart.calcPurchasePrice(shoppingCart.getGroceryList(), customer);

        assertEquals(161.30f, shoppingCart.getTotal());

        ShoppingCart shoppingCart1 = new ShoppingCart("Eric", database);
        shoppingCart1.addGroceryToCart(milk, 50);
        shoppingCart1.calcPurchasePrice(shoppingCart1.getGroceryList(), customer);

        assertEquals(164.59f, shoppingCart1.getTotal());

        ShoppingCart shoppingCart2 = new ShoppingCart("Thomas", database);
        shoppingCart2.addGroceryToCart(milk, 50);
        shoppingCart2.addGroceryToCart(milk, 1);
        shoppingCart2.calcPurchasePrice(shoppingCart2.getGroceryList(), customer);

        assertEquals(0.00f, shoppingCart2.getTotal());

    }

    /**
     * Testing that grocery list item
     * has been added to the list
     */
    @Test
    public void addGroceryToCart()
    {
        String beef = "Beef";
        shoppingCart.addGroceryToCart(beef, 2);

        assertTrue(shoppingCart.getGroceryList().contains(beef));
    }

    /**
     * Testing that the initial value of the
     * shopping cart is returned
     */
    @Test
    public void getTotal()
    {
        assertEquals(0.0f, shoppingCart.getTotal());
    }

    /**
     *  Testing to make sure the grocery list is
     *  returned and initialized correctly
     */
    @Test
    public void getGroceryList()
    {
        assertNotNull(shoppingCart.getGroceryList());
    }

    @Test
    public void getName()
    {
        assertEquals("Michael's Cart", shoppingCart.getName());
    }
}