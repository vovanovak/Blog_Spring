/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vova
 */
public class CookieWorker {
    public static void addUsernameAndPassword(HttpServletResponse response,
                        HttpServletRequest request, String username, String password){
        if (checkIfUsernameAndPasswordExist(response, request)){
            deleteUsernameAndPassword(response, request);
        }
        
        int id = DB.getUserId(username);
       
        response.addCookie(new Cookie("username", username));
        response.addCookie(new Cookie("password", password));
        response.addCookie(new Cookie("userid", Integer.toString(id)));
    }
    
    public static void deleteUsernameAndPassword(HttpServletResponse response,
                        HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        
        for(Cookie c:cookies){
            if (c.getName().equals("username") || c.getName().equals("password") || c.getName().equals("userid"))
            {
                c.setMaxAge(0);
                c.setPath(request.getContextPath());
                response.addCookie(c);
            }
        }
       
    }
    
    public static boolean checkIfUsernameAndPasswordExist(HttpServletResponse response,
                        HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        
        for(Cookie c:cookies){
            if (c.getName().equals("username") || c.getName().equals("password") || c.getName().equals("userid"))
                return true;
        }
        return false;
    }
    
    public static String getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        
        for(Cookie c: cookies){
            if (c.getName().equals(name))
                return c.getValue();
        }
        return null;
    }
}
