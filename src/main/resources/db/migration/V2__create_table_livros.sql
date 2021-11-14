create table livros(
	id bigint not null auto_increment,
	titulo varchar(100) not null,
	dataDeLancamento date not null,
	numeroDePaginas int not null,
	primary key(id)
);