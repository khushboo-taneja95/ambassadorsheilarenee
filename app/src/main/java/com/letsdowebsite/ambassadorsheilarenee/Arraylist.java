package com.letsdowebsite.ambassadorsheilarenee;

/**
 * Created by Dell on 5/16/2018.
 */
public class Arraylist {
    String name;
    String description;
    int image;

    public Arraylist(String description, String name, int image) {
        this.name = name;
        this.image=image;
        this.description=description;


    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public int getImage() {
        return image;
    }}
