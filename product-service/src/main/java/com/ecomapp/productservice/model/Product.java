package com.ecomapp.productservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    private long id;
    @Column(name = "product_name", length = 100)
    private String name;
    private double price;
    private String description;


}
