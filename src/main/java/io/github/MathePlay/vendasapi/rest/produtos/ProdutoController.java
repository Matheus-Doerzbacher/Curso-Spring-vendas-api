package io.github.MathePlay.vendasapi.rest.produtos;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.MathePlay.vendasapi.model.Produto;
import io.github.MathePlay.vendasapi.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public List<ProdutoFormRequest> getLista(){
		return repository.findAll().stream().map(p -> ProdutoFormRequest.fromModel(p)).collect(Collectors.toList());
	}

	@PostMapping
	public ProdutoFormRequest salvar( @RequestBody ProdutoFormRequest produto ) {
		Produto entidadeProduto = produto.toModel();
		repository.save(entidadeProduto);
		return ProdutoFormRequest.fromModel(entidadeProduto);
	}
	
	@PutMapping("{idProduto}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idProduto, @RequestBody ProdutoFormRequest produto ) {
		Optional<Produto> produtoExistente = repository.findById(idProduto); 
		
		if (produtoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Produto entidade = produto.toModel();
		entidade.setIdProduto(idProduto);
		repository.save(entidade);
		
		return ResponseEntity.ok().build();
	}
}
