package io.github.MathePlay.vendasapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_produto")
	private Integer idProduto;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column(name = "descricao", length = 255)
	private String descricao;
	
	@Column(name = "preco", precision = 16, scale = 2)
	private BigDecimal preco;
	
	@Column
	private String codigo;
	
	@Column (name = "data_cadastro")
	private LocalDate dataCadastro;
	
	public Produto() {
		super();
	}
	
	public Produto(String nome, String descricao, BigDecimal preco, String codigo) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.codigo = codigo;
	}
	
	public Produto(Integer iProduto, String nome, String descricao, BigDecimal preco, String codigo) {
		super();
		this.idProduto = iProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.codigo = codigo;
	}

	@PrePersist
	@PreUpdate
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
		
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer id_produto) {
		this.idProduto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Produto [id_produto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", codigo=" + codigo + "]";
	}
	
}
