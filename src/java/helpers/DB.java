/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import entities.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Vova
 */
public class DB {
    private static SessionFactory sessions =
        new Configuration().configure().buildSessionFactory(); 
    
    public static List<User> getAllUsers(){
    
        Session session = sessions.openSession();
            
        List<User> lst = (List<User>)session.createSQLQuery("select * from `user`").
                            addEntity(User.class).list();

        session.close();
        
        return lst;
    }
    
    public static List<Post> getAllPosts(){
        Session session = sessions.openSession();
            
        List<Post> lst = (List<Post>)session.createSQLQuery("select * from `post`").
                            addEntity(Post.class).list();

        session.close();
        
        return lst;
    }
    
    public static boolean checkUsernameAndEmailUnique(String username, String email){
        Session session = sessions.openSession();
            
        List<User> lst = (List<User>)session.createSQLQuery("select * from `user` where `username` = '" + username + "' or `email` = '" + email + "';").
                            addEntity(User.class).list();

        session.close();
        
        return lst.size() == 0;
    }
    
    public static List<Comment> getAllComments(){
        Session session = sessions.openSession();
            
        List<Comment> lst = (List<Comment>)session.createSQLQuery("select * from `comment`").
                            addEntity(Comment.class).list();

        session.close();
        
        return lst;
    }
    
    public static Like1 getLike(int userid, int postid){
        Session session = sessions.openSession();
            
        List<Like1> lst = (List<Like1>)session.createSQLQuery("select * from `like1` where userid = " + userid + " and postid = " + postid + ";").
                            addEntity(Like1.class).list();

        session.close();
        
        return lst.get(0);
    }
    
    public static void removeLike(Like1 like){
        Session session = sessions.openSession();
        session.beginTransaction();
        session.delete(like);
        session.getTransaction().commit();        
        session.close();
    }
    
    public static boolean signIn(String email, String password){
        Session session = sessions.openSession();
        
        List lst = session.createSQLQuery("select * from `user` where `username` = \'" +
                            email + "\'" + " and `password` = \'" + password +  "\';").list();
                           
        
        boolean res = lst.size() > 0;
        
        session.close();
        
        return res;
    }
    
    public static void register(User user){
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();                 
        session.close();
    }
    
    public static void addPost(Post post){
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();                 
        session.close();
    }
    
    public static void addComment(Comment comment){
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();                 
        session.close();
    }
    
    public static void addLike(Like1 like){
    Session session = sessions.openSession();
        session.beginTransaction();
        session.save(like);
        session.getTransaction().commit();                 
        session.close();
    }
    
    public static void addConfig(Config conf){
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(conf);
        session.getTransaction().commit();                 
        session.close();
    }
    
    public static void deletePost(Post post){
        Session session = sessions.openSession();
        session.beginTransaction();
        session.delete(post);
        session.getTransaction().commit();                 
        session.close();
    }

    public static int getUserId(String username) {
       Session session = sessions.openSession();
        
        List lst = session.createSQLQuery("select * from `user` where `username` = '"
                            + username + "';").addEntity(User.class).list();
        int id = ((User)lst.get(0)).getId();

        session.close();
        
        return id;
    }
    
    public static List<Config> getUserSettings(int uid) {
       Session session = sessions.openSession();
        
        List<Config> lst = (List<Config>)session.createSQLQuery("select * from `config` where `userid` = "
                            + uid + ";").addEntity(Config.class).list();
        session.close();
        
        return lst;
    }
    
    public static String getUsernameById(int id) {
       Session session = sessions.openSession();
        
        List lst = session.createSQLQuery("select * from `user` where `id` = "
                            + id + ";").addEntity(User.class).list();
        String uname = ((User)lst.get(0)).getUsername();

        session.close();
        
        return uname;
    }

    public static List<Post> getUserPosts(int userid){
        Session session = sessions.openSession();
        
        List<Post> lst = (List<Post>)session.createSQLQuery("select * from `post` where `userid` = "
                            + userid + " order by `id` desc;").addEntity(Post.class).list();
        

        session.close();
        
        return lst;
    }
    
    public static List<Like1> getPostLikes(int postid){
        Session session = sessions.openSession();
        
        List<Like1> lst = (List<Like1>)session.createSQLQuery("select * from `like1` where `postid` = "
                            + postid + ";").addEntity(Like1.class).list();
        
        session.close();
        
        if (lst == null)
            return new ArrayList<Like1>();
        return lst;
    }
    
    public static List<Comment> getPostComments(int postid){
        Session session = sessions.openSession();
        
        List<Comment> lst = (List<Comment>)session.createSQLQuery("select * from `comment` where `postid` = "
                            + postid + ";").addEntity(Comment.class).list();
        session.close();
        
        if (lst == null)
            return new ArrayList<Comment>();
        
        return lst;
    }
    
    public static String getUserIdByPostId(int postid){
        Session session = sessions.openSession();
        
        List<Post> lst = (List<Post>)session.createSQLQuery("select * from `post` where `id` = "
                            + postid + ";").addEntity(Post.class).list();
        session.close();
        
        return Integer.toString(lst.get(0).getUserid());
    }
    
    public static List<Post> searchPosts(String request){
        Session session = sessions.openSession();
        
        List<Post> lst = (List<Post>)session.createSQLQuery("select * from `post` where `postheader` like '%"
                            + request + "%';").addEntity(Post.class).list();
        
        session.close();
        
        return lst;
    }

    public static boolean hasLike(int uid, int pid) {
        Session session = sessions.openSession();
        
        List<Like1> lst = (List<Like1>)session.createSQLQuery("select * from `like1` where `userid` = " + uid + " and `postid` = " + pid + ";").addEntity(Like1.class).list();

        session.close();
        
        return !lst.isEmpty();
    }
    
    @Override
    protected void finalize() throws Throwable {
        sessions.close();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
