package pers.npcka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginRegisterController {

    @RequestMapping("login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("register")
    public String toRegister() {
        return "register";
    }
}
