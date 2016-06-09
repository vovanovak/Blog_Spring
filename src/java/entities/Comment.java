/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import helpers.DB;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Vova
 */

@Entity
@Table
public class Comment implements Serializable {
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")                 
    private int id;
    
    @Column
    private int postid;
    
    @Column
    private int userid;
    
    @Column
    private String commentbody;
    
    @Column
    private Date commentdate;
    
    public Comment(){
        id = -1;
        postid = -1;
        userid = -1;
        commentbody = "";
        commentdate = new Date();
    }
    
    public Comment(int id, int postid, int userid,
                   String commentbody, Date commentdate){
        this.id = id;
        this.postid = postid;
        this.userid = userid;
        this.commentbody = commentbody;
        this.commentdate = commentdate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the commentbody
     */
    public String getCommentbody() {
        return commentbody;
    }

    /**
     * @param commentbody the commentbody to set
     */
    public void setCommentbody(String commentbody) {
        this.commentbody = commentbody;
    }

    /**
     * @return the commentdate
     */
    public Date getCommentdate() {
        return commentdate;
    }

    /**
     * @param commentdate the commentdate to set
     */
    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }
    
    
    public String getUsername(){
        return DB.getUsernameById(userid);
    }
}
