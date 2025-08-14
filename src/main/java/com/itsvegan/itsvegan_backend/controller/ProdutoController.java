package com.itsvegan.itsvegan_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.itsvegan.itsvegan_backend.model.Produto;
import com.itsvegan.itsvegan_backend.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return repository.save(produto);
    }
}
