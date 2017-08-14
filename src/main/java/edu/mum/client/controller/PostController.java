package edu.mum.client.controller;

import edu.mum.client.model.Post;
import edu.mum.client.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/detail")
    public String detailPost(){
        return "postDetail";
    }
}
