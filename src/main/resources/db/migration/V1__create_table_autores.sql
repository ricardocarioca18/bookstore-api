create table autores(
	id bigint not null auto_increment,
	nome varchar(100) not null,
	matricula varchar(100) not null,
	idade int not null,
	senha varchar(100) not null,
	primary key(id)
);
