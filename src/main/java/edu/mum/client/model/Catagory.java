package edu.mum.client.model;


import java.util.List;

/**
 * Created by yentran
 */
public class Catagory {
    List<Product> products;
    List<WishList> wishLists;
    private String id;
    private String name;


    public Catagory() {
    }

    public String getCata_id() {
        return id;
    }

    public void setCata_id(String cata_id) {
        this.id = cata_id;
    }

    public String getCata_name() {
        return name;
    }

    public void setCata_name(String cata_name) {
        this.name = cata_name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
