package com.example.testcomparison.intrastructure.service;

import com.example.testcomparison.domain.entities.bedsheet.BedSheet;
import com.example.testcomparison.intrastructure.api.repo.BedSheetRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedSheetService {
    private final BedSheetRepo bedSheetRepo;

    public BedSheetService(BedSheetRepo bedSheetRepo){
        this.bedSheetRepo = bedSheetRepo;
    }

    public BedSheet save(BedSheet bedSheet){
        return bedSheetRepo.save(bedSheet);
    }

    public Optional<BedSheet> findById(Long id){
        return bedSheetRepo.findById(id);
    }

    public void deleteById(Long id){
        bedSheetRepo.deleteById(id);
    }

    public List<BedSheet> findAll(){
       return bedSheetRepo.findAll();
    }
}
