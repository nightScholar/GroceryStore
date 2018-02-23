package com.grocerystore;

import java.util.ArrayList;
import java.util.List;

/**
 * Database for grocery application
 */
public class Database
{
    private String name;
    private List<Item> itemList = new ArrayList<>();

    private Item beef = new Beef();
    private Item bread = new Bread();
    private Item cereal = new Cereal();
    private Item chicken = new Chicken();
    private Item eggs = new Eggs();
    private Item milk = new Milk();
    private Item oatmeal = new Oatmeal();

    /**
     * Database constructor, which takes a name as one
     * argument and all items are automatically added
     * upon instantiation
     */

    public Database(String name)
    {
        this.name = name;
        itemList.add(beef);
        itemList.add(bread);
        itemList.add(cereal);
        itemList.add(chicken);
        itemList.add(eggs);
        itemList.add(milk);
        itemList.add(oatmeal);
    }

    /**
     * Get the item passed into getItem method from database
     * itemList. If item is not found, method returns null
     */
    public Item getItem(String itemID)
    {
        for(Item item : itemList)
        {
            if(item.getItemName().equals(itemID))
            {
                return item;
            }
        }

        return null;
    }
}
