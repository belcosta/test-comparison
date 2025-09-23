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
@RequiredArgsConstructor
public class BedSheetDTO{

    private ProductType productType = ProductType.BED_SHEET;

    private BigDecimal price;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TextileMaterial material;

    @NonNull
    @Enumerated(EnumType.STRING)
    private BedSheetSize size;


}
