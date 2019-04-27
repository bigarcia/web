DROP TABLE Locacao;
DROP TABLE Locadora;
DROP TABLE Cliente;

create table Cliente(
    /*id_cliente integer not null generated always as identity(start with 1, increment by 1),*/
    email_cliente varchar(50) not null,
    senha_cliente varchar(100) not null,
    cpf_cliente varchar(15) not null,
    nome_cliente varchar(50) not null,
    telefone_cliente varchar(20) not null, 
    sexo_cliente varchar(1) not null,
    nascimento_cliente varchar(10) not null,
    PRIMARY KEY (cpf_cliente)
);

create table Locadora(
    cnpj_locadora varchar(14) not null,
    email_locadora varchar(50) not null,
    senha_locadora varchar(100) not null,
    nome_locadora varchar(50) not null,
    cidade_locadora varchar(50) not null,
    PRIMARY KEY (cnpj_locadora)
);

create table Locacao(
    id_locacao integer not null generated always as identity(start with 1, increment by 1),
    data_dia varchar(50) not null,
    cpf_cliente varchar(15) not null,
    cnpj_locadora varchar(14) not null,
    /*constraint Locacao1_FK FOREIGN KEY (cnpj_locadora) REFERENCES Locadora(cnpj_locadora), */
    PRIMARY KEY (id_locacao),
    FOREIGN KEY (cpf_cliente) REFERENCES Cliente(cpf_cliente),
    FOREIGN KEY (cnpj_locadora) REFERENCES Locadora(cnpj_locadora)
);

/* insert into Cliente(email_cliente, senha_cliente, cpf_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente) values ('maria@email.com', 'abc123', '23101125810', 'Maria Silva', '01638421441', 'f', '1970-09-01');
insert into Cliente(email_cliente, senha_cliente, cpf_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente) values ('joao@email.com', 'zwx012', '40161827955', 'Joao Costa', '01638521133', 'm', '1987-10-02');

insert into Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora) values ('123456789123', 'locadora_locaki@locaki.com', 'senhalocadora', 'LocAki', 'São Carlos - SP');
insert into Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora) values ('987147963200', 'locadora_superfilmes@superfilmes.com', 'superfilmes', 'Super Filmes', 'São Carlos - SP');

insert into Locacao(data_dia, cpf_cliente, cnpj_locadora) values ('15/04/2019', '23101125810', '987147963200'); */

create table Usuario
(
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
senha varchar(100) not null,
ativo smallint not null,
CONSTRAINT Usuario_PK PRIMARY KEY (id)
);

create table Papel (
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
nome varchar(50) not null,
constraint Papel_PK PRIMARY KEY (id)
);