package com.web.webclient.config;

import com.web.webclient.WebclientApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface WebContext {

    @ModelAttribute
    void addContext(Model model);
}
