package com.itsvegan.itsvegan_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SobreController {

    @GetMapping("/sobre-nos")
    public String sobreNos() {
        return "sobre-nos";
    }
}