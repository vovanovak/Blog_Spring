/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import com.google.gson.Gson;
import entities.Comment;
import entities.FullPost;
import entities.Like1;
import entities.Post;
import entities.PostAdditionalInfo;
import helpers.CookieWorker;
import helpers.DB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Vova
 */
@Controller
public class Search {
    public Search(){
        
    }
    
    @RequestMapping(value={"/search"},method=RequestMethod.GET)
   
    public String search(ModelMap model){
        return "search";
    }
    
    @RequestMapping(value={"/search"},method=RequestMethod.POST)
    @ResponseBody
    public String search(@RequestParam("request") String searchReq,
                        
                        ModelMap model, HttpServletRequest request){
        
        List<Post> posts = DB.searchPosts(searchReq);
        
        List<FullPost> full = new ArrayList<>();
        for(Post p:posts){
            
            full.add(new FullPost(p, new PostAdditionalInfo(DB.getUsernameById(p.getUserid()), p.getId(), DB.getPostLikes(p.getId()), DB.getPostComments(p.getId()))));
        }

        Gson gson = new Gson();
         
        return gson.toJson(full);
    }
    
    @RequestMapping(value={"/getusername"},method=RequestMethod.POST)
    @ResponseBody
    public String getusername(@RequestParam("userid") String uid,
                        ModelMap model, HttpServletRequest request){
       String username = DB.getUsernameById(Integer.parseInt(uid));
        System.out.println("Username: " + username);
        return username;
    }
    
    @RequestMapping(value={"/haslike"},method=RequestMethod.POST)
    @ResponseBody
    public String haslike(@RequestParam("postid") String pid,
                        @CookieValue("userid") String uid,
                        ModelMap model, HttpServletRequest request){
        String res =  Boolean.toString(DB.hasLike(Integer.parseInt(uid), Integer.parseInt(pid)));
        System.out.println("Result " + res);
        return res;
    }
}
