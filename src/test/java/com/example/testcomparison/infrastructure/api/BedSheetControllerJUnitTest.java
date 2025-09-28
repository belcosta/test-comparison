package com.example.testcomparison.infrastructure.api;

import com.example.testcomparison.domain.dto.BedSheetDTO;
import com.example.testcomparison.domain.entities.ProductType;
import com.example.testcomparison.domain.entities.bedsheet.BedSheet;
import com.example.testcomparison.domain.entities.bedsheet.BedSheetSize;
import com.example.testcomparison.domain.entities.bedsheet.TextileMaterial;
import com.example.testcomparison.intrastructure.api.BedSheetController;
import com.example.testcomparison.intrastructure.service.BedSheetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class BedSheetControllerJUnitTest {

    private BedSheetService bedSheetService;
    private BedSheetController bedSheetController;

    @BeforeEach
    public void setUp() {
        bedSheetService = Mockito.mock(BedSheetService.class);
        bedSheetController = new BedSheetController();
        bedSheetController.bedSheetService = bedSheetService;
    }

    @Test
    public void testCreateBedSheet() {

        BedSheetDTO dto = createDto(TextileMaterial.BAMBOO, BigDecimal.valueOf(10L), BedSheetSize.DOUBLE);
        BedSheet createdBedSheet = BedSheet.from(dto);
        createdBedSheet.setId(1L);

        Mockito.when(bedSheetService.createOrUpdate(any(BedSheet.class))).thenReturn(createdBedSheet);

        BedSheet result = bedSheetController.createBedSheet(dto);

        Assertions.assertEquals(createdBedSheet, result);
    }

    @Test
    public void testUpdateBedSheet() {
        BedSheet bedSheet = new BedSheet(TextileMaterial.SILK, BigDecimal.ONE, BedSheetSize.KING);
        bedSheet.setId(1L);

        BedSheetDTO dto = new BedSheetDTO(TextileMaterial.COTTON, BigDecimal.TEN, BedSheetSize.SINGLE);

        Mockito.when(bedSheetService.findById(eq(1L))).thenReturn(Optional.of(BedSheet.from(dto)));
        Mockito.when(bedSheetService.createOrUpdate(BedSheet.from(dto))).thenReturn(bedSheet);
    }

    @Test
    public void testDeleteBedSheet() {

        Long id = 1L;

        Mockito.doNothing().when(bedSheetService).deleteById(eq(id));

        bedSheetController.deleteBedSheet(id);

        Mockito.verify(bedSheetService).deleteById(eq(id));

    }

    @Test
    public void testGetAllBedSheet() {

        List<BedSheet> allBedSheets = Arrays.asList(new BedSheet(), new BedSheet());

        Mockito.when(bedSheetService.findAll()).thenReturn(allBedSheets);

        List<BedSheet> result = bedSheetController.getAllBedSheet();

        Assertions.assertEquals(allBedSheets, result);
        Mockito.verify(bedSheetService).findAll();
    }

    private BedSheetDTO createDto(TextileMaterial material, BigDecimal price, BedSheetSize size) {
        BedSheetDTO dto = new BedSheetDTO();
        dto.setPrice(price);
        dto.setMaterial(material);
        dto.setProductType(ProductType.BED_SHEET);
        dto.setSize(size);
        return dto;
    }
}