package com.web.webclient.web;


import com.web.webclient.config.WebContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController implements WebContext {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @Override
    public void addContext(Model model) {
        model.addAttribute("pageTitle", "Home");
    }
}
