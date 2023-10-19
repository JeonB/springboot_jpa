package com.example.springboot_jpa.jpashop.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("/thisIsTest")
    public String test(@Param("nono") String str,Model model){
        String testValue = "";
        model.addAttribute(("fuchk"), testValue );

        return "amazing";
    }
}
