/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Vova
 */
public class FullPost {
    private Post post;
    private PostAdditionalInfo info;
    
    public FullPost(){
        post = new Post();
        info = new PostAdditionalInfo();
        
    }
    
    public FullPost(Post post, PostAdditionalInfo info){
        this.post = post;
        this.info = info;
       
    }

    /**
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * @return the info
     */
    public PostAdditionalInfo getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(PostAdditionalInfo info) {
        this.info = info;
    }
                      
}
