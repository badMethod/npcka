package pers.npcka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuideController {

    @RequestMapping("news")
    public String news(){
        return "news";
    }

    @RequestMapping("guide")
    public String guide(){
        return "guide";
    }
}
