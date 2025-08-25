package com.itsvegan.itsvegan_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/cardapio")
    public String cardapio() {
        return "cardapio.html";
    }

    @GetMapping("/nossa-proposta")
    public String nossaProposta() {
        return "nossa-proposta.html";
    }

    @GetMapping("/armazem")
    public String armazem() {
        return "armazem.html";
    }

    @GetMapping("/carreiras")
    public String carreiras() {
        return "carreiras.html";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq.html";
    }

    @GetMapping("/contato")
    public String contato() {
        return "contato.html";
    }

    @GetMapping("/aniversarios")
    public String aniversarios() {
        return "aniversarios.html";
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