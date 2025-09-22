package com.example.testcomparison.domain.entities.bedsheet;

import com.example.testcomparison.domain.entities.Product;
import com.example.testcomparison.domain.entities.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name="bed_sheet")
public class BedSheet extends Product {

    @NonNull
    @Enumerated
    private TextileMaterial material;

    @NonNull
    @Enumerated
    private BedSheetSize size;

    public BedSheet(TextileMaterial textileMaterial, BedSheetSize bedSheetSize, ProductType productType, BigDecimal price) {
        super();
    }

    public BedSheet() {

    }
}
