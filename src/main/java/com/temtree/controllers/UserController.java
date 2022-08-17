/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.pojo.User;
import com.temtree.services.UserService;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 *
 * @author admin
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(
            Model model,
            @ModelAttribute(name = "user") @Valid User user,
            BindingResult result) {

        String errMsg = "";
        System.out.println("com.temtree.controllers.UserController.registerProcess()");
        System.out.println(user.getPassword().equals(user.getConfirmPassword()));
        System.out.println(user.getPassword());
        System.out.println(user.getConfirmPassword());

        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Đã có lỗi xảy ra";
            }
        } else {
            errMsg = "Mật khẩu không đúng";
        }
        model.addAttribute("errMsg", errMsg);

        if (result.hasErrors()) {
            return "register";
        }

        return "register";
    }
}
