package io.github.MathePlay.vendasapi.rest.clientes;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.MathePlay.vendasapi.model.Cliente;

public class ClienteFormRequest {
	
	private Integer idCliente;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	public ClienteFormRequest() {
		super();
	}
	
	public ClienteFormRequest(Integer idCliente, LocalDate nascimento, String nome, String cpf, String endereco,
			String telefone, String email, LocalDate dataCadastro) {
		super();
		this.idCliente = idCliente;
		this.nascimento = nascimento;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}


	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Cliente toModel() {
		return new Cliente(idCliente, nascimento, nome, cpf, endereco, telefone, email, dataCadastro);
	}
	
	public static ClienteFormRequest fromModel(Cliente cliente) {
		return new ClienteFormRequest(
				cliente.getIdCliente(), 
				cliente.getNascimento(), 
				cliente.getNome(), 
				cliente.getCpf(), 
				cliente.getEndereco(), 
				cliente.getTelefone(),
				cliente.getEmail(), 
				cliente.getDataCadastro());
	}
	
}
