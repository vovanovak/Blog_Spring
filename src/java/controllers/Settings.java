/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import com.google.gson.Gson;
import entities.Comment;
import entities.Config;
import entities.FullPost;
import entities.Post;
import entities.PostAdditionalInfo;
import helpers.CookieWorker;
import helpers.DB;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vova
 */
@Controller
public class Settings {
    public Settings(){
        
    }
    
    @RequestMapping(value={"/settings"},method=RequestMethod.GET)
    public String showSettings(@CookieValue("userid") String uid, ModelMap model){
        
        List<Config> settings = DB.getUserSettings(Integer.parseInt(uid));
        
        model.addAttribute("settings", settings);
        
        return "settings";
    }
    
    @RequestMapping(value={"/settingsget"},method=RequestMethod.POST)
    @ResponseBody
    public String getSettings(@CookieValue("userid") String uid, ModelMap model){
        
        List<Config> settings = DB.getUserSettings(Integer.parseInt(uid));
        
        Gson gson = new Gson();
        
        return gson.toJson(settings);
    }
    
    @RequestMapping(value={"/settingssave"},method=RequestMethod.POST)
    public String saveSettings(@RequestParam("elemid") String elemid, 
                        @RequestParam("prop") String prop, 
                        @RequestParam("value") String val,
                        @CookieValue("userid") String uid,
                        ModelMap model){
        
        Config conf = new Config();
        
        conf.setUserid(Integer.parseInt(uid));
        conf.setProperty(prop);
        conf.setElement(elemid);
        conf.setValue(val);
        
        DB.addConfig(conf);
        
        List<Config> settings = DB.getUserSettings(Integer.parseInt(uid));
        
        model.addAttribute("settings", settings);
        
        return "settings";
    }
}
