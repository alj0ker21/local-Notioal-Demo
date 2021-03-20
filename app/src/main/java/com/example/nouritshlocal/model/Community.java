package com.example.nouritshlocal.model;

import java.io.Serializable;

public class Community implements Serializable {
    private String name;
    private String description;
    private int imageReference;

    public Community( String name, int imageReference, String description){
        this.name = name;
        this.description = description;
        this.imageReference = imageReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageReference() {
        return imageReference;
    }

    public void setImageReference(int imageReference) {
        this.imageReference = imageReference;
    }
}
