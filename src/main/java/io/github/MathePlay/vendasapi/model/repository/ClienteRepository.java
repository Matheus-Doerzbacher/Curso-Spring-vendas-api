package io.github.MathePlay.vendasapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.MathePlay.vendasapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
