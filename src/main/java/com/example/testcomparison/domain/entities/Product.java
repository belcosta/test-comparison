package com.example.testcomparison.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@MappedSuperclass
@Getter
@Setter
public abstract class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Enumerated
    private ProductType type;

    @NonNull
    private BigDecimal price;

}
