create schema if not exists shopping;

create table shopping.shop (
    id bigserial primary key,
    user_identifier varchar(100) not null,
    shop_date timestamp not null,
    total float not null
);

create table shopping.item(
    shop_id bigserial references shopping.shop(id),
    product_identifier varchar(100) not null,
    price float not null
)