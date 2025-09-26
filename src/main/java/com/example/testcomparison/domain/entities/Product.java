package com.example.testcomparison.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private BigDecimal price;

    @NonNull
    @Enumerated(EnumType.STRING)
    private ProductType productType;

}
