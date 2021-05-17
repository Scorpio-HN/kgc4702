package com.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String test1(Model model){

        model.addAttribute("mess","你是烧饼");

        return "success";
    }
}
