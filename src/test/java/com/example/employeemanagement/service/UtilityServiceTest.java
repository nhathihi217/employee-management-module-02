package com.example.employeemanagement.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilityServiceTest {

    private final UtilityService utilityService = new UtilityService();

    @Test
    void formatsNameWithNormalizedWhitespace() {
        assertEquals("Nguyen Van An", utilityService.formatName("  NGUYEN   VAN an "));
    }

    @Test
    void generatesEmployeeCodeWithNamePrefix() {
        String code = utilityService.generateEmployeeCode("Nguyen Van An");
        assertTrue(code.startsWith("NGU-"));
        assertEquals(12, code.length());
    }
}
