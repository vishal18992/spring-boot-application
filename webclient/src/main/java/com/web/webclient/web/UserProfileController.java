package com.web.webclient.web;

import com.web.webclient.entity.Users;
import com.web.webclient.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserProfileController {

    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/profile")
    public String renderUserProfile(Model model, Principal principal){
        String login = principal.getName();
        Users user = usersRepository.getUserByUserName(login);
        model.addAttribute("currentUser", user);
        return "user/profile";
    }
}
