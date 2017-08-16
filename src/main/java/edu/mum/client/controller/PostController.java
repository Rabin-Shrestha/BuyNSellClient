package edu.mum.client.controller;

import edu.mum.client.model.Comment;
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

import java.util.Calendar;
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

        Post post = postService.getById(id);
        model.addAttribute("post",post);

        User poster=userService.getById(post.getUserId()); // need to replace by post.getUserId()
        model.addAttribute("poster",poster);
        return "postDetail";
    }

    @PostMapping("/addComment/{postId}")
    public String addPostComment(Model model, Comment comment, @PathVariable("postId") String postId) {

        System.out.println("I am from add Post comment " + comment + postId);
        Post post = postService.getById(postId);

        comment.setCommentedOn(Calendar.getInstance().getTime());
        comment.setUserId("59926786ba478e144fb629dd");

        String commentId=post.getId()+post.getUserId()+comment.getCommentedOn();
        comment.setId(commentId);

        post.getListOfComments().add(comment);

        System.out.println("New comment added:"+post.getListOfComments());
        postService.update(post);

        model.addAttribute(post);
        return "redirect:/post/detail/"+postId;
    }

    @PostMapping("/deleteComment/{postId}")
    public String deletePostComment(Model model, Comment comment, @PathVariable("postId") String postId) {

        System.out.println("I am from delete Post comment " + comment + "Post id : " + postId);
        Post post = postService.getById(postId);

        System.out.println("****** from url : " + comment.getId());

        Comment delcomment=comment;
        for (Comment cmt : post.getListOfComments() ) {
            System.out.println("******* from Object : " + cmt.getId());

            if(cmt.getId().equals(comment.getId())){
                System.out.println("----- Match found----");
                delcomment=cmt;
                break;
            }
        }

        post.getListOfComments().remove(delcomment);

        System.out.println("Comment deleted:"+post.getListOfComments());
        postService.update(post);

        model.addAttribute(post);
        return "redirect:/post/detail/"+postId;
    }

}
