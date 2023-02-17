package com.camp.admin.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(Exception.class)  
    public String except(Exception e, Model model){

        return "pages-error-404";
    }
}
