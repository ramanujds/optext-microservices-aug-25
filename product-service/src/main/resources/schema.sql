CREATE TABLE product
(
    id           BIGINT           NOT NULL,
    product_name VARCHAR(100),
    price        DOUBLE PRECISION NOT NULL,
    description  VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);