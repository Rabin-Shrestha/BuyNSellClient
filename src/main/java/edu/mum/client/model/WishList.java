package edu.mum.client.model;

/**
 * Created by yentran
 */
public class WishList {

    private String id;
    private String desc;
    private String image;

//	@DBRef
//	private Catagory catagory;


    public WishList() {}

    @Override
    public String toString() {
        return "WishList {id='" + id + '\'' + ", desc='" + desc + '\'' + ", image='" + image + '\'' +'}';
    }

    public String getWl_id() {
        return id;
    }

    public void setWl_id(String wl_id) {
        this.id = wl_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
//	public Catagory getCatagory() {
//		return catagory;
//	}
//
//	public void setCatagory(Catagory catagory) {
//		this.catagory = catagory;
//	}


}
