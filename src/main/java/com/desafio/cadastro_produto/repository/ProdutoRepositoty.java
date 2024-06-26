package com.desafio.cadastro_produto.repository;

import com.desafio.cadastro_produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositoty extends JpaRepository<Produto,Long> {
}
