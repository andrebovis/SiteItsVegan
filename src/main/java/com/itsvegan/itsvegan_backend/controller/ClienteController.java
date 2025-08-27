package com.itsvegan.itsvegan_backend.controller;

import com.itsvegan.itsvegan_backend.model.Cliente;
import com.itsvegan.itsvegan_backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        String hashedPassword = passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(hashedPassword);
        return clienteRepository.save(cliente);
    }
    
    @GetMapping("/{id}")
    public Optional<Cliente> getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }

    @GetMapping("/whatsapp/{id}")
    public RedirectView redirectWhatsapp(@PathVariable Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            String numero = cliente.getTelefone();
            
            
            String numeroLimpo = numero.replaceAll("[^0-9]", "");
            
            String urlWhatsapp = "https://wa.me/" + numeroLimpo;

            return new RedirectView(urlWhatsapp);
        } else {
            
            return new RedirectView("/clientes");
        }
    }
}