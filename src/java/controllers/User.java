/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.Comment;
import entities.FullPost;
import entities.Like1;
import entities.Post;
import entities.PostAdditionalInfo;
import helpers.CookieWorker;
import helpers.DB;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Vova
 */
@Controller
public class User {
    public User(){
        
    }
    
    @RequestMapping(value={"/user/{id}"},method=RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, @CookieValue("userid") String uid,
                        ModelMap model, HttpServletRequest request){
        System.out.println("User id: " + id);
        
        List<Post> posts = DB.getUserPosts(id);
        
        
        List<FullPost> full = new ArrayList<>();
        for(Post p:posts){
            full.add(new FullPost(p, new PostAdditionalInfo(
                                DB.getUsernameById(p.getUserid()),
                                p.getId(), DB.getPostLikes(p.getId()),
                                DB.getPostComments(p.getId()))));
        }
        
        System.out.println("Full: " + full.size());
        model.addAttribute("list", full);
        model.addAttribute("comment", new Comment());
        model.addAttribute("currentUserId", Integer.parseInt(uid));
        
        return "user";
    }
    
    @RequestMapping(value={"/commentA"}, method=RequestMethod.POST)
    public String sendComment(@RequestParam("PostId") String postId,
                        @RequestParam("CommentBody") String commentBody,
                        @CookieValue("userid") String uid, ModelMap model,
                        HttpServletRequest request, HttpServletResponse response){
        Comment comment = new Comment();
        comment.setCommentbody(commentBody);
        comment.setPostid(Integer.parseInt(postId.substring(0, postId.length() - 1)));
        comment.setUserid(Integer.parseInt(CookieWorker.getCookie(request, "userid")));
        
        DB.addComment(comment);
        
        List<Post> posts = DB.getUserPosts(Integer.parseInt(CookieWorker.getCookie(request, "userid")));
        System.out.println("Posts: " + posts.size());
        List<FullPost> full = new ArrayList<>();
        for(Post p:posts){
            
            full.add(new FullPost(p, new PostAdditionalInfo(DB.getUsernameById(p.getUserid()), p.getId(), DB.getPostLikes(p.getId()), DB.getPostComments(p.getId()))));
        }
        
        
        model.addAttribute("currentUserId", Integer.parseInt(uid));
        model.addAttribute("list", full);
        model.addAttribute("comment", new Comment());
        
        
        return "redirect:/user/" + DB.getUserIdByPostId(comment.getPostid());
    }
    
    @RequestMapping(value="/likeA",  method=RequestMethod.POST)
    public String sendLike(@RequestParam("postid") String postId, @RequestParam("plus") String val, 
                        @CookieValue("userid") String uid, ModelMap model){
        Like1 like = new Like1();
        if (val.equals("1")){
            like.setPostid(Integer.parseInt(postId));
            like.setUserid(Integer.parseInt(uid));

            DB.addLike(like);
        } else {
            like = DB.getLike(Integer.parseInt(uid), Integer.parseInt(postId));
            DB.removeLike(like);
        }
        
        List<Post> posts = DB.getUserPosts(Integer.parseInt(uid));
        System.out.println("Posts: " + posts.size());
        List<FullPost> full = new ArrayList<>();
        for(Post p:posts){
            
            full.add(new FullPost(p, new PostAdditionalInfo(DB.getUsernameById(p.getUserid()), p.getId(), DB.getPostLikes(p.getId()), DB.getPostComments(p.getId()))));
        }

        model.addAttribute("list", full);
        model.addAttribute("comment", new Comment());
        model.addAttribute("currentUserId", Integer.parseInt(uid));
        
        return "user";
    }
}
