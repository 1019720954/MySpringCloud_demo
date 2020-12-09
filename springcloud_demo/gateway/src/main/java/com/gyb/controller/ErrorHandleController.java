package com.gyb.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandleController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "error";
    }
    @RequestMapping("/error")
    public String errorMsg(){
        return "你点击的频率太快了!";
    }
}
