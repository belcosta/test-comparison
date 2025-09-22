package com.example.testcomparison.intrastructure.service;

import com.example.testcomparison.domain.entities.bedsheet.BedSheet;
import com.example.testcomparison.domain.entities.bedsheet.TextileMaterial;
import com.example.testcomparison.intrastructure.api.repo.BedSheetRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedSheetService {
    private final BedSheetRepo bedSheetRepo;

    public BedSheetService(BedSheetRepo bedSheetRepo){
        this.bedSheetRepo = bedSheetRepo;
    }

    public BedSheet save(BedSheet bedSheet){
        return bedSheetRepo.save(bedSheet);
    }
    public List<BedSheet> findByMaterial(){
       return bedSheetRepo.findByMaterial(TextileMaterial.BAMBOO);
    }
}
