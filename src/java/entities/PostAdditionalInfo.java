/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vova
 */
public class PostAdditionalInfo {
    private String username;
    
    private int postid;
    
    private List<Like1> likes;
    
    private List<Comment> comments;
    
    
    public PostAdditionalInfo(){
        username = "";
        postid = -1;
        likes = new ArrayList<>();
        comments = new ArrayList<>();
    }
    
    public PostAdditionalInfo(String username, int postid, List<Like1> likes, List<Comment> comments){
        this.username = username;
        this.postid = postid;
        this.likes = likes;
        this.comments = comments;
    }

    /**
     * @return the postid
     */
    public int getPostid() {
        return postid;
    }

    /**
     * @param postid the postid to set
     */
    public void setPostid(int postid) {
        this.postid = postid;
    }

    /**
     * @return the likes
     */
    public List<Like1> getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setLikes(List<Like1> likes) {
        this.likes = likes;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean containsUserid(int userid){
        
        boolean res = false;
        for (Like1 like : likes)
        {
            if (like.getUserid() == userid){
                res = true;
                break;
            }

        }
        return res;

        
    }
    
    
}
