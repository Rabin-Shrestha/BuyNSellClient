package edu.mum.client.controller;

import edu.mum.client.model.User;
import edu.mum.client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    // UserService userService;

    @Autowired
    private UserService uService;

    @RequestMapping("/")
    public String home(Model model) {

        //User p = uService.getById("598e7ea5fb3cd11dac9d4189");
        List<User> users = uService.getAll();
        model.addAttribute("users", users);
        //uService.getUsers();
        System.out.println("list:"+users);
        return "Hello world";
    }

}
