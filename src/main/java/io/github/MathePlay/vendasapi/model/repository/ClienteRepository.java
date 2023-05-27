package io.github.MathePlay.vendasapi.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.MathePlay.vendasapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("SELECT c FROM Cliente c WHERE upper(c.nome) LIKE :nome and c.cpf LIKE :cpf")
	Page<Cliente> buscarPorNomeCpf( 
			@Param("nome") String nome, 
			@Param("cpf") String cpf, 
			Pageable pageable);
	
}
