package com.sirialkillers.shoponthego.Models;

/**
 * @author Ioakeim James Theologou
 * @version 8/12/2017
 *
 */
public class CategoryModel{
    private String categoryId;
    private String categoryName;
    private String description;

    public CategoryModel(String categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    public CategoryModel(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }


    public CategoryModel(String categoryName) {

        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
