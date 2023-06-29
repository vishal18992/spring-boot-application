package com.web.webclient.web;

import com.web.webclient.config.WebContext;
import com.web.webclient.entity.Users;
import com.web.webclient.helper.Message;
import com.web.webclient.model.SignupDto;
import com.web.webclient.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/web/signup")
public class SignUpController{

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String signup(Model model){
        model.addAttribute("user", new SignupDto());
        return "/authentication/signup";
    }

    @PostMapping
    public String processSignup(@Valid @ModelAttribute("signupData")
                                    SignupDto signupDto, Model model, BindingResult result, HttpSession session){
        try{
            if(!signupDto.getPassword().equals(signupDto.getConfirm_password())){
                ObjectError error = new ObjectError("confirm_password", "Password mismatch!!");
                result.rejectValue("confirm_password", "error.signup", "Password mismatch!!");
                result.addError(error);
            }
            if(result.hasErrors()){
               throw new Exception("You have validation exception.");
            }

            signupDto.setActive(true);
            signupDto.setRole("ROLE_USER");
            long user  = usersService.create(signupDto);
            model.addAttribute("user", new SignupDto());
            session.setAttribute("message", new Message("Successfully Signup !!", "alert-success"));
        }catch (Exception ex){
            model.addAttribute("user", signupDto);
            session.setAttribute("message", new Message("Something went wrong!!" + ex.getMessage(), "alert-danger"));
        }
        return "authentication/signup";
    }
}
