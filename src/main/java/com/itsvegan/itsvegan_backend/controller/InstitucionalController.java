package com.itsvegan.itsvegan_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstitucionalController {

    @GetMapping("/sobre-nos")
    public String sobreNos() {
        return "sobre-nos";
    }

    @GetMapping("/nossa-proposta")
    public String nossaProposta() {
        return "nossa-proposta";
    }

    @GetMapping("/armazem")
    public String armazem() {
        return "armazem";
    }

    @GetMapping("/carreiras")
    public String carreiras() {
        return "carreiras";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/aniversarios")
    public String aniversarios() {
        return "aniversarios";
    }

    @GetMapping("/contato")
    public String contato() {
        return "contato";
    }
}