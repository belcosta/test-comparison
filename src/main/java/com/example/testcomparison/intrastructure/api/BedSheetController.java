package com.example.testcomparison.intrastructure.api;

import com.example.testcomparison.domain.dto.BedSheetDTO;
import com.example.testcomparison.domain.entities.bedsheet.BedSheet;
import com.example.testcomparison.intrastructure.service.BedSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
public class BedSheetController {

    @Autowired
    public BedSheetService bedSheetService;

    @PostMapping("/bed-sheet/create")
    public BedSheet createBedSheet(@RequestBody final BedSheetDTO dto){
        return bedSheetService.save(BedSheet.from(dto));
    }
    @PostMapping("/bed-sheet/update-{id}")
    public BedSheet updateBedSheet(@PathVariable(name = "id") Long id, @RequestBody BedSheetDTO dto) {
        BedSheet existingBedSheet = bedSheetService.findById(id)
                .orElseThrow(() -> new RuntimeException("Bed sheet with id " + id + " not found"));

        BedSheet updatedBedSheet = BedSheet.from(dto);
        updatedBedSheet.setId(existingBedSheet.getId());
        return bedSheetService.save(updatedBedSheet);
    }

    @DeleteMapping("/bed-sheet/delete-{id}")
    public void deleteBedSheet(@PathVariable(name="id") final Long id){
        bedSheetService.deleteById(id);
    }

    @GetMapping(value="/bed-sheet/all")
    public List<BedSheet> getAllBedSheet(){
         return bedSheetService.findAll();
    }
}
