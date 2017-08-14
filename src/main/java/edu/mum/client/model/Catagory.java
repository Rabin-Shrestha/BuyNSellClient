package edu.mum.client.model;

import java.util.List;

/**
 * Created by yentran
 */
public class Catagory {

    @Override
	public String toString() {
		return "Catagory [id=" + id + ", name=" + name + "]";
	}

	private String id;
    private String name;


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
}
