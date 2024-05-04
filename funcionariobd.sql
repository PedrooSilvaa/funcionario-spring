CREATE DATABASE funcionariodb;
use funcionariodb;

CREATE TABLE funcionario(
id int auto_increment,
nome varchar(120),
anonascimento int,
funcao varchar(120),
constraint pk_banda primary key (id)
);
