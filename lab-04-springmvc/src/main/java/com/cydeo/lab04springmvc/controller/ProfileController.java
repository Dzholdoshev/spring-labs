package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class ProfileController {


    @RequestMapping("/profile")
    public String getProfile(Model model){

        Profile profile = new Profile();
        profile.setName("James");
        profile.setSurname("Lannister");
        profile.setUserName("Blonde");
        profile.setEmail("james.lannister@gmail.com");
        profile.setPhoneNumber("323232323");
        profile.setCreatedDate(LocalDateTime.now());
        model.addAttribute("profile",profile);
        return "profile/profile-info";

    }
}
