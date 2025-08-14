package com.itsvegan.itsvegan_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itsvegan.itsvegan_backend.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
