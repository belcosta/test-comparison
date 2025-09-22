package com.example.testcomparison.intrastructure.api.repo;

import com.example.testcomparison.domain.entities.bedsheet.BedSheet;
import com.example.testcomparison.domain.entities.bedsheet.TextileMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedSheetRepo extends JpaRepository<BedSheet, Long> {

    List<BedSheet> findByMaterial(TextileMaterial material);

}
