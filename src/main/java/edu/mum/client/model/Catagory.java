package edu.mum.client.model;

import java.util.List;

/**
 * Created by yentran
 */
public class Catagory{

	private String id;
    private String name;
    private List<WishList> wishLists;

    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public Catagory() {}


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
    


	@Override
   	public String toString() {
   		return "Catagory {id='" + id + '\''+ ", name='" + name + '\'' +'}';
   	}
}
