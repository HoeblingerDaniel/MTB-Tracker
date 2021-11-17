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

    @Test
    public void itShouldReturn3_GivenIII() {
        assertEquals(3, RomanToArabic.toArabic("III"));
    }

    @Test
    public void itShouldReturn5_GivenV() {
        assertEquals(5, RomanToArabic.toArabic("V"));
    }

    @Test
    public void itShouldReturn6_GivenVI() {
        assertEquals(6, RomanToArabic.toArabic("VI"));
    }

    @Test
    public void itShouldReturn7_GivenVII() {
        assertEquals(7, RomanToArabic.toArabic("VII"));
    }

    @Test
    public void itShouldReturn10_GivenX() {
        assertEquals(10, RomanToArabic.toArabic("X"));
    }

    @Test
    public void itShouldReturn11_GivenXI() {
        assertEquals(11, RomanToArabic.toArabic("XI"));
    }

    @Test
    public void itShouldReturn15_GivenXV() {
        assertEquals(15, RomanToArabic.toArabic("XV"));
    }

    @Test
    public void itShouldReturn26_GivenXXVI() {
        assertEquals(26, RomanToArabic.toArabic("XXVI"));
    }
}
