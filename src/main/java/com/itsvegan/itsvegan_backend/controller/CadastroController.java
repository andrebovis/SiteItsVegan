package com.itsvegan.itsvegan_backend.controller;

import com.itsvegan.itsvegan_backend.model.Cliente;
import com.itsvegan.itsvegan_backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String processarCadastro(Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/"; // Redireciona para a página inicial após o cadastro
    }
}