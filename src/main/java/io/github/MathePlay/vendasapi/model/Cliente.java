package io.github.MathePlay.vendasapi.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_cliente")
		private Integer idCliente;
		private LocalDate nascimento;
		private String nome;
		private String cpf;
		private String endereco;
		private String telefone;
		private String email;
		@Column(name = "data_cadastro")
		private LocalDate dataCadastro;
		

		public Cliente() {
			super();
		}

		public Cliente(Integer idCliente, LocalDate nascimento, String nome, String cpf, String endereco,
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

		public Cliente(LocalDate nascimento, String nome, String cpf, String endereco, String telefone, String email) {
			super();
			this.nascimento = nascimento;
			this.nome = nome;
			this.cpf = cpf;
			this.endereco = endereco;
			this.telefone = telefone;
			this.email = email;
		}
		
		@PrePersist
		public void prePersist() {
			setDataCadastro(LocalDate.now());
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

		@Override
		public String toString() {
			return "Cliente [idCliente=" + idCliente + ", nascimento=" + nascimento + ", nome=" + nome + ", cpf=" + cpf
					+ ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", dataCadastro="
					+ dataCadastro + "]";
		}
}
