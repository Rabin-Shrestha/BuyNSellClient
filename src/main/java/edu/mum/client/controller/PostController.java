package edu.mum.client.controller;

import edu.mum.client.model.Post;
import edu.mum.client.model.User;
import edu.mum.client.services.PostService;
import edu.mum.client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Controller
@RequestMapping("/post")
public class PostController {
    // PostService postService;

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String showAllPosts(Model model) {

        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "postList";
    }

    @GetMapping("/add")
    public String addPost(){
        return "addPost";
    }

    @PostMapping("/add")
    public String addPost(Model model, Post post) {

        Post newPost = postService.add(post);
        System.out.println("New post added:"+newPost);
        return "redirect:/post/list";
    }

    @GetMapping("/detail/{id}")
    public String detailPost(Model model, @PathVariable("id") String id){
        System.out.println("************* " + id);
        Post post = postService.getById(id);
        model.addAttribute("post",post);

        User poster=userService.getById("5990d1d6fb3cd1267c8f4b1a"); // need to replace by post.getUserId()

        model.addAttribute("poster",poster);
        return "postDetail";
    }
}
