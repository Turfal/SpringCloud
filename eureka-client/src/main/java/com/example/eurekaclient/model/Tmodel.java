package com.example.eurekaclient.model;

public class Tmodel {
    private int id;
    private String product;

    public Tmodel(int id, String product) {
        this.id = id;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
