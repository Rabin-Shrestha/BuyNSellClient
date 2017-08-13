package edu.mum.client.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.client.Constants;
import edu.mum.client.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Service
public class UserService extends AbstractService<User>{

    public UserService() {
        super();
        baseUrl = Constants.USER_URL;
    }

    public User add(User User){
        System.out.println("posting user");
        return post(User, null);
    }

    public User update(User User){
        return post(User, "/"+User.getId());
    }

    public User getById(String id){
        return get("/"+id);
    }

    public List<User> getAll(){
        return getList(null);
    }

    public void delete(Long id){
        delete("/"+id);
    }


}
