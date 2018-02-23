package com.grocerystore;

/**
 * Customer class that demonstrate tax exempt or store member status
 */

public class Customer
{
    private String name;
    private boolean isTaxExempt;
    private boolean isStoreMember;

    /**
     * Constructor requiring all member variables
     */

    public Customer(String name, boolean isTaxExempt, boolean isStoreMember)
    {
        this.name = name;
        this.isTaxExempt = isTaxExempt;
        this.isStoreMember = isStoreMember;
    }

    /**
     * Get customer name
     */

    public String getName()
    {
        return this.name;
    }

    /**
     * Get customer tax exempt status
     */

    public boolean isTaxExempt()
    {
        return this.isTaxExempt;
    }


    /**
     * Get customer store member status
     */

    public boolean isStoreMember()
    {
        return this.isStoreMember;
    }
}
