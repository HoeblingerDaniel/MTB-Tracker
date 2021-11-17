package org.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToArabicTest
{
    @Test
    public void itShouldReturn1_GivenI() {
        assertEquals(1, RomanToArabic.toArabic("I"));
    }

    @Test
    public void itShouldReturn2_GivenII() {
        assertEquals(2, RomanToArabic.toArabic("II"));
    }
}
