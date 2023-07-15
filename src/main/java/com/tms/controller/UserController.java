package com.tms.controller;

import com.tms.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get-user")
    public String getUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
       // System.out.println(user.getId().equals(1));
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "unsuccess";
        }
        System.out.println(user);
        return "success";
    }
}
