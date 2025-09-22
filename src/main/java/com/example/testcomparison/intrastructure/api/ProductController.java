package com.example.testcomparison.intrastructure.api;

import com.example.testcomparison.domain.entities.ProductType;
import com.example.testcomparison.domain.entities.bedsheet.BedSheet;
import com.example.testcomparison.domain.entities.bedsheet.BedSheetSize;
import com.example.testcomparison.domain.entities.bedsheet.TextileMaterial;
import com.example.testcomparison.intrastructure.service.BedSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private BedSheetService bedSheetService;

    @GetMapping(value="/add-bed-sheet")
    public BedSheet addBedSheet(){
        BedSheet bedSheet = new BedSheet( TextileMaterial.BAMBOO, BedSheetSize.DOUBLE, ProductType.BED_SHEET, BigDecimal.valueOf(20.03
        ));

        bedSheet.setType(ProductType.BED_SHEET);
        bedSheet.setId(1L);

        return bedSheetService.save(bedSheet);

    }
    @GetMapping(value="/get-bed-sheet")
    public List<BedSheet> getBedSheet(){

        List<BedSheet> result =  bedSheetService.findByMaterial();
        System.out.println("### re"+ result);
        System.out.println("### dsajkdba");
        return result;
    }

}
