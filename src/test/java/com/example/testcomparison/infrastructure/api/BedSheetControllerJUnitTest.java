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

//    @AfterEach
//    public void tearDown() {
//
//    }

    @Test
    public void testCreateBedSheet() {


        BedSheetDTO dto = createDto();
        BedSheet createdBedSheet = new BedSheet();
        createdBedSheet.setId(1L);

        Mockito.when(bedSheetService.save(any(BedSheet.class))).thenReturn(createdBedSheet);

        BedSheet result = bedSheetController.createBedSheet(dto);

        Assertions.assertEquals(createdBedSheet, result);
        Mockito.verify(bedSheetService).save(any(BedSheet.class));

    }

    @Test
    public void updateBedSheetShouldReturnUpdatedBedSheetWhenIdExists() {


        Long id = 1L;
        BedSheetDTO dto = createDto();
        BedSheet existingBedSheet = new BedSheet();
        existingBedSheet.setId(id);
        BedSheet updatedBedSheet = BedSheet.from(dto);
        updatedBedSheet.setId(id);

        Mockito.when(bedSheetService.findById(eq(id))).thenReturn(Optional.of(existingBedSheet));
        Mockito.when(bedSheetService.save(any(BedSheet.class))).thenReturn(updatedBedSheet);

        BedSheet result = bedSheetController.updateBedSheet(id, dto);

        Assertions.assertEquals(updatedBedSheet, result);
        Mockito.verify(bedSheetService).findById(eq(id));
        Mockito.verify(bedSheetService).save(any(BedSheet.class));

    }

    @Test
    public void updateBedSheetShouldThrowExceptionWhenIdDoesNotExist() {


        Long id = 1L;
        BedSheetDTO dto = createDto();

        Mockito.when(bedSheetService.findById(eq(id))).thenReturn(Optional.empty());

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () ->
            bedSheetController.updateBedSheet(id, dto)
        );

        Assertions.assertEquals("Bed sheet with id " + id + " not found", exception.getMessage());
        Mockito.verify(bedSheetService).findById(eq(id));
        Mockito.verify(bedSheetService, Mockito.never()).save(any(BedSheet.class));

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


        List<BedSheet> bedSheets = Arrays.asList(new BedSheet(), new BedSheet());

        Mockito.when(bedSheetService.findAll()).thenReturn(bedSheets);

        List<BedSheet> result = bedSheetController.getAllBedSheet();

        Assertions.assertEquals(bedSheets, result);
        Mockito.verify(bedSheetService).findAll();

    }

    private BedSheetDTO createDto() {
        BedSheetDTO dto = new BedSheetDTO();
        dto.setPrice(BigDecimal.valueOf(10L));
        dto.setMaterial(TextileMaterial.BAMBOO);
        dto.setProductType(ProductType.BED_SHEET);
        dto.setSize(BedSheetSize.KING);
        return dto;
    }
}