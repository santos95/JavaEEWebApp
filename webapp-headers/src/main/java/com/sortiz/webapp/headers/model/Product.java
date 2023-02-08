package com.sortiz.webapp.headers.model;

public class Product {
    private long Id;
    private String name;
    private String tipoProducto;
    private int price;


    public Product() {
    }

    public Product(long id, String name, String tipoProducto, int price) {
        Id = id;
        this.name = name;
        this.tipoProducto = tipoProducto;
        this.price = price;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
