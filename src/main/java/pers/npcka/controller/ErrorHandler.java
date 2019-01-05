package pers.npcka.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView excep(Exception e) {
        ModelAndView view = new ModelAndView("error");
        e.printStackTrace();
        view.addObject("message", e.getMessage());
        return view;
    }
}
