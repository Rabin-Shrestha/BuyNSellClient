package edu.mum.client;

import edu.mum.client.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuynsellclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuynsellclientApplication.class, args);
		UserService userService = new UserService();

		//System.out.println(userService.getUser("598e7198fb3cd114982e9455").toString());
        System.out.println(userService.getAll());

    }
}
