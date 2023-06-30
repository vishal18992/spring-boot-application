package com.web.webclient.web;

import com.web.webclient.config.WebContext;
import com.web.webclient.model.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController implements WebContext {

    @GetMapping(value = "/web/login")
    public String login(){
        return "authentication/login";
    }

//    @PostMapping(value = "/web/login")
//    public String processLogin(@Valid @ModelAttribute("loginData") LoginDto login, BindingResult result){
//        System.out.println(login);
//        System.out.println(result);
//        if(result.hasErrors()){
//            System.out.println(result);
//            return "authentication/login";
//        }
//        return "index";
//    }

    @Override
    public void addContext(Model model) {
        model.addAttribute("pageTitle", "Login");
        model.addAttribute("loginData", new LoginDto());
    }
}
