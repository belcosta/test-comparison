package com.example.testcomparison.domain.dto;

import com.example.testcomparison.domain.entities.ProductType;
import com.example.testcomparison.domain.entities.bedsheet.BedSheetSize;
import com.example.testcomparison.domain.entities.bedsheet.TextileMaterial;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BedSheetDTO{

    private ProductType productType = ProductType.BED_SHEET;

    @NonNull
    private BigDecimal price;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TextileMaterial material;

    @NonNull
    @Enumerated(EnumType.STRING)
    private BedSheetSize size;

    public BedSheetDTO(TextileMaterial material, BigDecimal price, BedSheetSize size) {
        this.price = price;
        this.material = material;
        this.size = size;
    }
}
