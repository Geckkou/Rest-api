# API REST

## Instruções 

- Execute os comando abaixo no Mysql ou qualquer outro SGBD de sua preferência.

## Comandos

### Cria um banco de dados: 
```sql
create database "Nome da base de dados"; (use o nome que você desejar)
use "Nome da base de dados";
```

### Cria as Tabelas: 

```sql
create table cliente(
	id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    telefone varchar(20) not null,
    
    primary key(id)
);

create table entrega(
	id bigint not null auto_increment,
    cliente_id bigint not null,
    taxa decimal(10,2) not null,
    status varchar(20) not null,
    data_pedido datetime not null,
    data_finalizacao datetime,
    
    destinatario_nome varchar(60) not null,
    destinatario_logradouro varchar(255) not null,
    destinatario_numero varchar(30) not null,
    destinatario_complemento varchar(60) not null,
    destinatario_bairro varchar(30) not null,
    
    primary key(id)
);

alter table entrega add constraint fk_entrega_cliente
foreign key (cliente_id) references cliente (id);

create table ocorrencia(
	id bigint not null auto_increment,
    entrega_id bigint not null,
    descricao text not null,
    data_registro datetime not null,
    
    primary key(id)
);

alter table ocorrencia add constraint fk_ocorrencia_entrega
foreign key (entrega_id) references entrega(id);
```

## Mais sobre.

- Se sua ide tive compatibilidade com SQL files você pode utilizar o Flyway que ja está configurado no projeto para usar as query sqls.
 - Se você não conhece segue  a documentação:  [FlyWay documentation](https://flywaydb.org/documentation/)


- A IDE que utilizei foi a intellij.

- Lembre-se de alterar o arquivo de configuração(application.properties) para conectar a sua database.

-  Dentro da API tratei exeções personalizidadas e como os dados vão ser exibidos.

- Lembre de o PostMan para fazer as requisição http.

 - Aqui o link da API já postada no heroku:  [API Link](https://aw-api-cadastro.herokuapp.com/) 
 complete com a rota das requisições.