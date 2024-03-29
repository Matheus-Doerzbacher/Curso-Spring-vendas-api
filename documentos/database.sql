CREATE DATABASE vendas;

CREATE TABLE tb_produto(
	ID_PRODUTO INT NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL,
	DESCRICAO VARCHAR(255),
	PRECO DECIMAL(16,2),
	CODIGO VARCHAR(20),
	DATA_CADASTRO DATE,
	PRIMARY KEY (ID_PRODUTO)
);


CREATE TABLE tb_cliente(
	ID_CLIENTE INT NOT NULL AUTO_INCREMENT,
	NASCIMENTO DATE NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	CPF VARCHAR(14) NOT NULL,
	ENDERECO VARCHAR(255) NOT NULL,
	TELEFONE VARCHAR(14),
	EMAIL VARCHAR(100),
	DATA_CADASTRO DATE,
	PRIMARY KEY(ID_CLIENTE)
);
