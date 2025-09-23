package com.example.testcomparison.domain.entities.bedsheet;

import com.example.testcomparison.domain.dto.BedSheetDTO;
import com.example.testcomparison.domain.entities.Product;
import jakarta.persistence.*;
import lombok.*;

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

    public static BedSheet from (BedSheetDTO dto){
        BedSheet bedSheet = new BedSheet();
        bedSheet.setProductType(dto.getProductType());
        bedSheet.setPrice(dto.getPrice());
        bedSheet.setMaterial(dto.getMaterial());
        bedSheet.setSize(dto.getSize());
        return bedSheet;
    }

}
