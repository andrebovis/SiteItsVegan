package com.itsvegan.itsvegan_backend.controller;

import com.itsvegan.itsvegan_backend.model.Candidatura;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarreirasController {

    @PostMapping("/enviar-candidatura")
    @ResponseBody
    public String receberCandidatura(@ModelAttribute Candidatura candidatura) {
        // Por enquanto, vamos apenas imprimir os dados no console do servidor.
        System.out.println("Candidatura recebida: " + candidatura);
        
        // Retornamos uma mensagem simples para o navegador.
        return "<h1>Obrigado por se candidatar! Em breve entraremos em contato.</h1>";
    }
}