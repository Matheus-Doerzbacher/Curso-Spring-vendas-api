package io.github.MathePlay.vendasapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.MathePlay.vendasapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
