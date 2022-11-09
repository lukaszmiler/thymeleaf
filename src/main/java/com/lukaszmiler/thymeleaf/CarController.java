package com.lukaszmiler.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarShow {


    @GetMapping("/hello")
    String hello(Model model){
        model.addAttribute("car", new Car(1, "Toyota", "Yaris", "white"));
        return "hello";
    }

}
