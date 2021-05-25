package com.webtemplate.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    public String home() {
        return "Hello from WebTemplate";
    }
}
