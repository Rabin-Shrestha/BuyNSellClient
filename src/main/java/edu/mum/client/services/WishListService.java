package edu.mum.client.services;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.client.model.Catagory;
import edu.mum.client.model.WishList;

@Service
public class WishListService {

	private final RestTemplate restTemplate;

    public WishListService() {
        this.restTemplate = new RestTemplate();
    }

    public Object[] getCatagories() {
        String urlGetList = "http://localhost:8080/catagory/all";
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlGetList, Object[].class);
        Object[] objects = responseEntity.getBody();
       System.out.println("panda" + objects);
        return objects;
    }
    
    public Catagory addNewCatagoryWL(String name) {
        return this.restTemplate.getForEntity("http://localhost:8080/catagory/addNLoad" + name, Catagory.class).getBody();
    }

    public Object[] postCatagories(Catagory cata) {
        String urlPostList = "http://localhost:8080/catagory/addNLoad";
        ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(urlPostList, cata, Object[].class);
        Object[] objects = responseEntity.getBody();
       
        return objects;
    }
    
    public Object[] getWishList() {
    		String urlGetList = "http://localhost:8080/wishlist/all";
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlGetList, Object[].class);
        Object[] objects = responseEntity.getBody();
       
        return objects;
    }
    public WishList addNewWishList(String desc, String image) {
    		return this.restTemplate.getForEntity("http://localhost:8080/wishlist/add" + desc + image, WishList.class).getBody();
    }
    
    public Object[] postWishlists(WishList wl) {
    		String urlPostList = "http://localhost:8080/wishlist/addNLoad";
        ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(urlPostList, wl, Object[].class);
        Object[] objects = responseEntity.getBody();
        System.out.println("panda test Service of WishList" + objects);
        return objects;
    }
}
