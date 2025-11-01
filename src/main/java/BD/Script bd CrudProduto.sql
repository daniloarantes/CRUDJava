CREATE DATABASE CrudProduto;

USE CrudProduto;

CREATE TABLE tbl_produto (
	id int(11) NOT NULL,
    descricao VARCHAR(70) NOT NULL,
    valor DOUBLE NOT NULL,
	quantidade INT(11) NOT NULL
    ) ENGINE=Innodb DEFAULT CHARSET=UTF8;
    
ALTER TABLE tbl_produto
	ADD PRIMARY KEY (id);
    
ALTER TABLE tbl_produto
	MODIFY id INT NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT=2;
    
INSERT INTO tbl_produto(descricao, valor, quantidade)
VALUES('Arroz', 2.50, 4);

SELECT * FROM tbl_produto;


CREATE TABLE tbl_usuarios (
	id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome varchar(80) NOT NULL,
    login varchar(50) NOT NULL,
    senha varchar(255) NOT NULL,
    tipo varchar(10) NOT NULL
    );
    

    











