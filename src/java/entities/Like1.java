/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
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
@Table(name = "like1")
public class Like1 implements Serializable{
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")   
    private int id;
    
    @Column
    private int userid;
    
    @Column
    private int postid;
    
    public Like1(){
        id = -1;
        postid= -1;
        userid = -1;
    }
    
    public Like1(int id, int userid, int postid){
        this.id = id;
        this.userid = userid;
        this.postid = postid;
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
}
