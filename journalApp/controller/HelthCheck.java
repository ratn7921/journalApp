package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthCheck {
   @GetMapping("/HelthCheck")
   public String HelthCheck(){
        return "System is running";
    }
}
