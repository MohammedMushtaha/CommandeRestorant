package com.example.commanderestorant.pojo;

public class FeaturedDataModel {

    private int image;
    private String name;
    private int rating;
    private String km;


    public FeaturedDataModel(int image, String name, int rating, String km) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.km = km;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }
}
