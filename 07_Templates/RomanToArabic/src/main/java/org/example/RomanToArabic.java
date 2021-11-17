package org.example;

public class RomanToArabic
{
    public static int toArabic(String romanNumber) {
        int arabicNumber = 0;
        if (romanNumber.charAt(0) == 'V') arabicNumber += 5;
        for (int i = 0; i < romanNumber.length(); i++) {
            if (romanNumber.charAt(i) == 'I') arabicNumber += 1;
        }
        return arabicNumber;
    }
}
