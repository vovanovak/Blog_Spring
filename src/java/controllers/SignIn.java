/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import helpers.DB;
import helpers.CookieWorker;
import entities.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Vova
 */

@Controller
public class SignIn {
    public SignIn(){
        
    }
    
    @RequestMapping(value={"/", "/signin"}, method=RequestMethod.GET)
    public String showPage(ModelMap model, HttpServletResponse response, HttpServletRequest request){
        model.addAttribute("user", new User());
        
//        if (CookieWorker.checkIfUsernameAndPasswordExist(response, request) == true){
//            boolean res = DB.signIn(CookieWorker.getCookie(request, "username"), CookieWorker.getCookie(request, "password"));    
//            if (res){
//                return "redirect:/home";
//            }
//        }
        
        return "signin";
    }
    
    @RequestMapping(value={"/signin"}, method=RequestMethod.POST)
    public String registerSubmit(@ModelAttribute User user, ModelMap model,
                        HttpServletResponse response, HttpServletRequest request){
        boolean res = DB.signIn(user.getUsername(), user.getPassword());
        //System.out.println(user.getUsername() + " " + user.getPassword());
        if (!res)
            return "signin";
        else
        {
            CookieWorker.addUsernameAndPassword(response, request, user.getUsername(), user.getPassword());
            return "redirect:/home";
        }
    }
}
