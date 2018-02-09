package com.example.samuel.davidmarket.Models;

import java.io.Serializable;

/**
 * Created by Samuel on 02-Feb-18.
 */

public class Products implements Serializable {

    private String measure, name;
    private int price;

    public Products() {
    }

    public String getMeasure() {
        return measure;
    }


    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
