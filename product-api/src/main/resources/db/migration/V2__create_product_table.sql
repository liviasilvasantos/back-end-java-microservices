create table products.product (
    id bigserial primary key,
    product_identifier varchar(100) not null,
    nome varchar(100) not null,
    descricao varchar(100) not null,
    preco float not null,
    category_id bigint references products.category(id)
);