package com.cb.chat_bot_slack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin("http://localhost:8080")
public class CommonViewController {
    /**
     * this method for render the upload APK file view
     * @return chat_bot.html
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chat_bot.html");
        return modelAndView;
    }

}
