package pers.npcka.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.npcka.model.Users;
import pers.npcka.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpSession session, String account, String password) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        Users user = null;
        try {
            user = userService.goToLogin(account, password);
        } catch (Exception e) {
            msgCode = "500";
            e.printStackTrace();
        }
        if (user != null) {
            session.setAttribute("user", user);
        } else {
            msgCode = "600";// 账号不存在
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    @ResponseBody
    public String register(String account, String password, String password2) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        if (password.equals(password2)) {
            int result = 0;
            try {
                result = userService.register(account, password);
            } catch (Exception e) {
                msgCode = "500";
                e.printStackTrace();
            }
            if (result < 1) {
                msgCode = "601"; // 账号已存在
            }
        } else {
            msgCode = "600"; // 两次密码输入错误
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }
}
