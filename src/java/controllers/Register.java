/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import helpers.DB;
import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Vova
 */
@Controller
public class Register {
    public Register(){
        
    }
    
    @RequestMapping(value={"/register"}, method=RequestMethod.GET)
    public String registerForm(ModelMap model){
            model.addAttribute("user", new User());
            model.addAttribute("errormsg", "");
            return "register";
    }
    
    @RequestMapping(value={"/register"}, method=RequestMethod.POST)
    public String registerSubmit(@ModelAttribute User user, ModelMap model){
        if (DB.checkUsernameAndEmailUnique(user.getUsername(), user.getEmail())){
            DB.register(user);
            return "redirect:/signin";
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("errormsg", "Username or email isn't unique please change your data!");
            return "register";
        }
        
        
    }
}
