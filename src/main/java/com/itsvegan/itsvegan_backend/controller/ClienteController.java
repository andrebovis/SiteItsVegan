package com.itsvegan.itsvegan_backend.controller;

import com.itsvegan.itsvegan_backend.dto.LoginRequest;
import com.itsvegan.itsvegan_backend.model.Cliente;
import com.itsvegan.itsvegan_backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        String senhaCriptografada = passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(senhaCriptografada);
        Cliente novoCliente = clienteRepository.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Tentativa de login recebida para o email: " + loginRequest.getEmail());
        
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(loginRequest.getEmail());

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            boolean senhaCorreta = passwordEncoder.matches(loginRequest.getSenha(), cliente.getSenha());

            if (senhaCorreta) {
                return ResponseEntity.ok("Login realizado com sucesso! Bem-vindo(a), " + cliente.getNome() + ".");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email não encontrado.");
        }
    }
}