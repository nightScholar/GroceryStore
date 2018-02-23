package com.grocerystore;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Database test class
 */

public class DatabaseTest
{
    /**
     * Creating Customer object for testing
     */
    private Database database = new Database("Superfresh");

    /**
     * Testing known items exist in database list
     */
    @Test
    public void getItemExists()
    {
        assertNotNull(database.getItem("Milk"));
        assertNotNull(database.getItem("Beef"));
        assertNotNull(database.getItem("Bread"));
        assertNotNull(database.getItem("Chicken"));
        assertNotNull(database.getItem("Cereal"));
        assertNotNull(database.getItem("Eggs"));
        assertNotNull(database.getItem("Oatmeal"));
    }

    /**
     * Testing items that do not exist in database
     */
    @Test
    public void ItemDoesNotExist()
    {
        assertNull(database.getItem("Pizza"));
    }
}