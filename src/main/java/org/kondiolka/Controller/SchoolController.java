package org.kondiolka.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//This controller is for handling HTTP REQUESTS on specific URLS
@RestController
public class SchoolController {
    @RequestMapping("/")
    public String index() {
        return "Welcome to index.html";
    }
}
