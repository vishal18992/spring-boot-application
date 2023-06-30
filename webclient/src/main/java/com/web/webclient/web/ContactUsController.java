package com.web.webclient.web;

import com.web.webclient.model.CrmLeadDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/contactus")
public class ContactUsController {

    @GetMapping
    public String contactus(){
        return "contactus";
    }

    @PostMapping
    public String processContactus(@ModelAttribute CrmLeadDto crmLeadDto){
        return "contactus-thank-you";
    }
}
