package pers.npcka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnswerController {

    @RequestMapping("answer")
    public String answer() {
        return "answer";
    }
}
