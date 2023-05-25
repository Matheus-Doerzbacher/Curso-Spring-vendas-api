package io.github.MathePlay.vendasapi.rest.clientes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.MathePlay.vendasapi.model.Cliente;
import io.github.MathePlay.vendasapi.model.repository.ClienteRepository;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin("*")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	public ResponseEntity<ClienteFormRequest> salvar(@ RequestBody ClienteFormRequest request) {
		Cliente cliente = request.toModel();
		repository.save(cliente);
		return ResponseEntity.ok(ClienteFormRequest.fromModel(cliente));
	}

	@PutMapping("{idCliente}")
	public ResponseEntity<Void> atualizar (
			@PathVariable Integer idCliente,
			@ RequestBody ClienteFormRequest request) {
		
		Optional<Cliente> clienteExistente =  repository.findById(idCliente);
		if(clienteExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente cliente = request.toModel();
		cliente.setIdCliente(idCliente);
		repository.save(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{idCliente}")
	public ResponseEntity<ClienteFormRequest> getById( @PathVariable Integer idCliente){
		return repository.findById(idCliente)
				.map(cliente -> ClienteFormRequest.fromModel(cliente))
				.map(clienteFR -> ResponseEntity.ok(clienteFR))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("{idCliente}")
	public ResponseEntity<Object> delete( @PathVariable Integer idCliente){
		return repository
				.findById(idCliente)
				.map(cliente -> {
					repository.delete(cliente);
					return ResponseEntity.noContent().build();
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public List<ClienteFormRequest> getLista(){
		return repository
				.findAll()
				.stream()
				.map(cliente -> ClienteFormRequest.fromModel(cliente))
				.collect(Collectors.toList());
	}
}
