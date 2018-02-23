package com.grocerystore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Customer Test class
 */
public class CustomerTest
{
    /**
     * Creating customer object for testing
     */

    private Customer customer = new Customer("Michael", true, true);
    private Customer customer2 = new Customer("Tommy", false, false);

    /**
     * Testing getName getter function
     */

    @Test
    public void getName()
    {
        assertEquals("Michael", customer.getName());
    }

    /**
     * Testing isTaxExempt getter for true condition function
     */

    @Test
    public void isTaxExemptTrue()
    {
        assertEquals(true, customer.isTaxExempt());
    }


    /**
     * Testing isTaxExempt getter for false condition function
     */
    @Test
    public void isTaxExemptFalse()
    {
        assertEquals(false, customer2.isTaxExempt());
    }

    /**
     * Testing storeMember getter function for true condition
     */

    @Test
    public void isStoreMemberTrue()
    {
        assertEquals(true, customer.isStoreMember());
    }

    /**
     * Testing storeMember getter function for false condition
     */
    @Test
    public void isStoreMemberFalse()
    {
        assertEquals(false, customer2.isStoreMember());
    }
}