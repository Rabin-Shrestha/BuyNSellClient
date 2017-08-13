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

   /* public User getUser(String userId) {
        return this.restTemplate.getForEntity("http://localhost:8080/user/" + userId, User.class).getBody();
    }

    public List<User> getUsers() {
        String urlGETList = "http://localhost:8080/user/";
        //ResponseEntity<Object[]> responseEntity = restTemplate.getForObject(urlGETList, Object[].class);
        ResponseEntity<List<User>> response =
                restTemplate.exchange(urlGETList,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                        });
        System.out.println("List:"+response.getBody());
        return response.getBody();
       *//* Object[] objects = responseEntity.getBody();
        for (Object o: objects
             ) {
            System.out.println(o);
        }
        ObjectMapper mapper =new ObjectMapper();


        String data=" {\n" +
                "        \"id\": \"598fcc6a11a2112e4bcd70d5\",\n" +
                "        \"userName\": \"User6\",\n" +
                "        \"password\": \"user6\",\n" +
                "        \"enabled\": true,\n" +
                "        \"email\": \"user6@gmail.com\",\n" +
                "        \"firstName\": \"Rabin\",\n" +
                "        \"lastName\": \"Shrestha\",\n" +
                "        \"address\": \"100 n 4 st\",\n" +
                "        \"zipcode\": \"52557\",\n" +
                "        \"phoneNo\": \"641457\",\n" +
                "        \"photoUrl\": \"photoRabin\",\n" +
                "        \"lastLogIn\": \"2017-10-01 10:20:30\",\n" +
                "        \"createdOn\": \"2017-08-12 03:45:30\",\n" +
                "        \"userReviewList\": [\n" +
                "            {\n" +
                "                \"id\": \"101\",\n" +
                "                \"content\": \"Awesome vendor\",\n" +
                "                \"reviewedOn\": 1507507200000,\n" +
                "                \"userId\": \"\",\n" +
                "                \"reviewedBy\": \"598e7198fb3cd114982e9455\",\n" +
                "                \"rating\": 9\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"102\",\n" +
                "                \"content\": \"Good vendor\",\n" +
                "                \"reviewedOn\": 1507593600000,\n" +
                "                \"userId\": \"\",\n" +
                "                \"reviewedBy\": \"598e7198fb3cd114982e9455\",\n" +
                "                \"rating\": 10\n" +
                "            }";


        try{
            User user=mapper.readValue(data,User.class);
            System.out.println("user parsed is "+user);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


*//*
    }*/

//    public static void main(String[] args) {
//        UserService userService=new UserService();
//        Object[] objects = userService.getUsers();
//        for(Object obj:objects){
//            System.out.print(obj);
//
//        }
//    }
}
