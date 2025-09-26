package com.example.testcomparison.domain.entities.bedsheet;

import com.example.testcomparison.domain.dto.BedSheetDTO;
import com.example.testcomparison.domain.entities.Product;
import com.example.testcomparison.domain.entities.ProductType;
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
    @Enumerated(EnumType.STRING)
    private TextileMaterial material;

    @NonNull
    @Enumerated(EnumType.STRING)
    private BedSheetSize size;

    public BedSheet(long bedSheetId, TextileMaterial material, BigDecimal one, BedSheetSize size) {
        this.setId(bedSheetId);
        this.setProductType(ProductType.BED_SHEET);
        this.setPrice(one);
        this.material = material;
        this.size = size;
    }

    public static BedSheet from (BedSheetDTO dto){
        BedSheet bedSheet = new BedSheet();
        bedSheet.setProductType(dto.getProductType());
        bedSheet.setPrice(dto.getPrice());
        bedSheet.setMaterial(dto.getMaterial());
        bedSheet.setSize(dto.getSize());
        return bedSheet;
    }

}
