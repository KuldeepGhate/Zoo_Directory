package com.example.kuldeep.zoodirectory;

import java.io.Serializable;

/**
 * Created by Kuldeep on 1/17/2015.
 */
public class Animal implements Serializable{

    private static final long serialVersionUID = 1L;
    private int icon;
    private String title;
    private String description;

    public Animal(){
        super();
    }

    public Animal(int icon, String title, String description){
        super();
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
