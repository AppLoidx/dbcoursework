package com.itmoprofessionals.dbcoursework.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionGeneratorTest {
    @Test
    public void text() {
        String generatedText = DescriptionGenerator.generateDescription();

        assertNotNull(generatedText);
        assertTrue(generatedText.split(" ").length > 50);
    }
}