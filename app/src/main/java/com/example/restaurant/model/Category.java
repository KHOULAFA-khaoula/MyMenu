package com.example.restaurant.model;

public class Category {
    int id,image;
    String nom_category;

    public Category(int id, String nom_category, int image) {
        this.id = id;
        this.nom_category = nom_category;
        this.image = image;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public String getNom_category() {
        return nom_category;
    }

    public int getImage() {
        return image;
    }
}
