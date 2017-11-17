package com.sirialkillers.shoponthego.Models;

import com.sirialkillers.shoponthego.Interfaces.ICategory;

/**
 * @author Ioakeim James Theologou
 * @version 16/11/2017
 * TODO: Create a test class for this model.
 *
 */
public class CategoryModel implements ICategory{
    String categoryId;
    String categoryName;
    String description;

    @Override
    public String getCategoryId() {

        return categoryId;
    }

    @Override
    public String getCategoryName() {

        return categoryName;
    }

    @Override
    public String getCategoryDescription() {

        return description;
    }
}
