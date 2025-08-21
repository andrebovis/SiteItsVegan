package com.itsvegan.itsvegan_backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/cardapio")
    public String cardapio() {
        return "cardapio.html";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro.html";
    }
}