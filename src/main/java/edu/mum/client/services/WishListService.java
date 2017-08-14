package edu.mum.client.services;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.client.model.Catagory;

@Service
public class WishListService {

	private final RestTemplate restTemplate;

    public WishListService() {
        this.restTemplate = new RestTemplate();
    }


    public Catagory addNewCatagoryWL(String name) {
        return this.restTemplate.getForEntity("http://localhost:8080/catagory/addNLoad" + name, Catagory.class).getBody();
    }

    public Object[] getCatagories(Catagory cata) {
        String urlPostList = "http://localhost:8080/catagory/addNLoad";
        ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(urlPostList, cata, Object[].class);
        Object[] objects = responseEntity.getBody();
       
        return objects;
    }
}
