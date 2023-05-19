package io.github.MathePlay.vendasapi.rest.produtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.MathePlay.vendasapi.model.Produto;

public class ProdutoFormRequest {
	
	private Integer idProduto;
	private String descricao;
	private String nome;
	private BigDecimal preco;
	private String codigo;
	
	@JsonFormat(pattern  = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	
	public ProdutoFormRequest() {
		super();
	}
	

	public ProdutoFormRequest(Integer idProduto, String descricao, String nome, BigDecimal preco, String codigo, LocalDate dataCadastro) {
		super();
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
		this.dataCadastro = dataCadastro;
	}


	public Produto toModel() {
		return new Produto(nome, descricao, preco, codigo);
	}
	
	public static ProdutoFormRequest fromModel(Produto produto)  {
		return new ProdutoFormRequest(
				produto.getIdProduto(), 
				produto.getDescricao(), 
				produto.getNome(), 
				produto.getPreco(), 
				produto.getCodigo(),
				produto.getDataCadastro()
		);
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer id_produto) {
		this.idProduto = id_produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
		return "ProdutoFormRequest [id_produto=" + idProduto + ", descricao=" + descricao + ", nome=" + nome
				+ ", preco=" + preco + ", codigo=" + codigo + "]";
	}

}
