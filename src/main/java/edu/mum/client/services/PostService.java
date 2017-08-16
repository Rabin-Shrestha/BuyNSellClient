package edu.mum.client.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.client.Constants;
import edu.mum.client.model.Comment;
import edu.mum.client.model.Post;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Service
public class PostService extends AbstractService<Post> {

    public PostService() {
        super();
        baseUrl = Constants.POST_URL;
    }

    public Post add(Post Post) {
        //System.out.println("posting post");
        return post(Post, null);
    }

    public void update(Post Post) {
        put(Post, "/" + Post.getId());
    }

    public Post getById(String id) {
        return get("/" + id);
    }

    public List<Post> getAll() {
        return getList(null);
    }

    public void delete(Long id) {

        delete("/" + id);
    }

    public Post deleteComment(Comment comment, String postId) {

        Post post = getById(postId);

        Comment delcomment = comment;
        for (Comment cmt : post.getListOfComments()) {

            if (cmt.getId().equals(comment.getId())) {
                delcomment = cmt;
                break;
            }
        }

        post.getListOfComments().remove(delcomment);

        update(post);

        return post;
    }

    /*Added by Rabin shrestha : to get post list based on userID*/
    public List<Post> getAllPostByUserId(String userId) {
        List<Post> allPosts = getList(null);
       /*Converting all Data Of LinkedHashedMap to list*/
        List<Post> postlists = new ObjectMapper().convertValue(allPosts, new TypeReference<List<Post>>() { });
        /*Filtering post based on UserId*/
        List<Post> usersPost = postlists.stream().filter(p -> p.getUserId().equals(userId)).collect(Collectors.toCollection(ArrayList::new));
        return usersPost;
    }

    public static void main(String[] args) {
        PostService postService = new PostService();
      //  System.out.println(" list of result" + postService.getAllPostByUserId("59936429527700167806a881"));
        try {
            File file=new File("errorLog.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file,true);
           fw.write("hello rabin how are y9ou donglsadkjfklj");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");

    }

}
