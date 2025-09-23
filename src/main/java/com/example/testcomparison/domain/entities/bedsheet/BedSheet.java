package com.example.testcomparison.domain.entities.bedsheet;

import com.example.testcomparison.domain.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name="bed_sheet")
@NoArgsConstructor
public class BedSheet extends Product{

    @NonNull
    private BigDecimal price;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TextileMaterial material;

    @NonNull
    @Enumerated(EnumType.STRING)
    private BedSheetSize size;

}
