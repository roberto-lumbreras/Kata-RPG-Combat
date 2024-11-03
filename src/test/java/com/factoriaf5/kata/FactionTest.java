package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FactionTest {
    @Test
    void testGetName() {
        assertTrue(Faction.ARCANE_CONCLAVE.getName().equals("The Arcane Conclave"));
    }

    @Test
    void testGetDescription() {
        assertTrue(Faction.ARCANE_CONCLAVE.getDescription().equals("An organization of wizards and sorcerers seeking knowledge and power through magic. They are dedicated to the study of the arcane arts and the preservation of ancient magical secrets."));
    }
}
