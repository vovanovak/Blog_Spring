/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class Post implements Serializable {
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")                 
    private int id;
    
    @Column
    private int userid;
    
    @Column
    private String postheader;
    
    @Column
    private String postbody;
    
    @Column
    private Date postdate;
    
    
    public Post(){
        id = -1;
        userid = -1;
        postheader = "";
        postbody = "";
        postdate = new Date();
    }
    
    public Post(int id, int userid, 
                        String postheader, String postbody,
                        Date postdate){
        this.id = id;
        this.userid = userid;
        this.postheader = postheader;
        this.postbody = postbody;
        this.postdate = postdate;
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
     * @return the postheader
     */
    public String getPostheader() {
        return postheader;
    }

    /**
     * @param postheader the postheader to set
     */
    public void setPostheader(String postheader) {
        this.postheader = postheader;
    }

    /**
     * @return the postbody
     */
    public String getPostbody() {
        return postbody;
    }

    /**
     * @param postbody the postbody to set
     */
    public void setPostbody(String postbody) {
        this.postbody = postbody;
    }

    /**
     * @return the postdate
     */
    public Date getPostdate() {
        return postdate;
    }

    /**
     * @param postdate the postdate to set
     */
    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }
}
