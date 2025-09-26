package com.example.testcomparison.infrastructure.api;

import com.example.testcomparison.domain.dto.BedSheetDTO;
import com.example.testcomparison.domain.entities.bedsheet.BedSheet;
import com.example.testcomparison.domain.entities.bedsheet.BedSheetSize;
import com.example.testcomparison.domain.entities.bedsheet.TextileMaterial;
import com.example.testcomparison.intrastructure.api.BedSheetController;
import com.example.testcomparison.intrastructure.service.BedSheetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.testcomparison.Utils.TestUtils.calculateTestDuration;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

    @WebMvcTest(BedSheetController.class)
    class BedSheetControllerSpringTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private BedSheetService bedSheetService; // injected mock

        @Autowired
        private ObjectMapper objectMapper;

        @TestConfiguration
        static class TestConfig {
            @Bean
            BedSheetService bedSheetService() {
                return Mockito.mock(BedSheetService.class);
            }
        }

        @Test
        void testCreateBedSheet() throws Exception {
            long start = System.nanoTime();

            BedSheetDTO dto = new BedSheetDTO(TextileMaterial.BAMBOO, BigDecimal.TEN, BedSheetSize.DOUBLE);
            BedSheet bedSheet = BedSheet.from(dto);
            bedSheet.setId(1L);

            when(bedSheetService.save(any(BedSheet.class))).thenReturn(bedSheet);

            mockMvc.perform(post("/bed-sheet/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(dto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.size", is("DOUBLE")))
                    .andExpect(jsonPath("$.price", is(10)))
                    .andExpect(jsonPath("$.material", is("BAMBOO")));

        calculateTestDuration(start);
        }

        @Test
        void testUpdateBedSheet() throws Exception {
            long start = System.nanoTime();

            long bedSheetId = 1L;
            BedSheetDTO dto = new BedSheetDTO(TextileMaterial.COTTON, BigDecimal.TEN, BedSheetSize.DOUBLE);
            BedSheet existingBedSheet = new BedSheet(bedSheetId, TextileMaterial.SILK, BigDecimal.ONE, BedSheetSize.QUEEN);
            BedSheet updatedBedSheet = new BedSheet(bedSheetId, TextileMaterial.COTTON, BigDecimal.TEN, BedSheetSize.DOUBLE);

            when(bedSheetService.findById(bedSheetId)).thenReturn(Optional.of(existingBedSheet));
            when(bedSheetService.save(any(BedSheet.class))).thenReturn(updatedBedSheet);

            mockMvc.perform(post("/bed-sheet/update-" + bedSheetId)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(dto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is((int) bedSheetId)))
                    .andExpect(jsonPath("$.material", is("COTTON")))
                    .andExpect(jsonPath("$.size", is("DOUBLE")))
                    .andExpect(jsonPath("$.price", is(10)));

        calculateTestDuration(start);
        }

        @Test
        void testDeleteBedSheet() throws Exception {
            long start = System.nanoTime();

            long bedSheetId = 1L;
            doNothing().when(bedSheetService).deleteById(bedSheetId);

            mockMvc.perform(delete("/bed-sheet/delete-" + bedSheetId))
                    .andExpect(status().isOk());

            verify(bedSheetService, times(1)).deleteById(bedSheetId);

        calculateTestDuration(start);
        }

        @Test
        void testGetAllBedSheet() throws Exception {
            long start = System.nanoTime();

            BedSheet bedSheet1 = new BedSheet(1L, TextileMaterial.COTTON, BigDecimal.ONE, BedSheetSize.SINGLE);
            List<BedSheet> allBedSheets = Collections.singletonList(bedSheet1);

            when(bedSheetService.findAll()).thenReturn(allBedSheets);

            mockMvc.perform(get("/bed-sheet/all"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].material", is("COTTON")));

        calculateTestDuration(start);
        }
    }

