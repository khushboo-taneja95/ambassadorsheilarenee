package com.letsdowebsite.ambassadorsheilarenee.ui.home;

/**
 * Created by Dell on 5/16/2018.
 */
public class Arraylist {
    String name;
    int image;
    String description;


    public Arraylist(String name, String description, int image) {
        this.name = name;
        this.image=image;
        this.description = description;

    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getImage() {
        return image;
    }}
