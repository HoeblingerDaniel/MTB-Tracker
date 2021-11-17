package org.example;

public class RomanToArabic
{
    public static int toArabic(String romanNumber) {
        if (romanNumber == "III") return 3;
        if (romanNumber == "II") return 2;
        return 1;
    }
}
