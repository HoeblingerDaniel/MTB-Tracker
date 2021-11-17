package org.example;

public class RomanToArabic
{
    public static int toArabic(String romanNumber) {
        int arabicNumber = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            if (romanNumber.charAt(i) == 'I') arabicNumber += 1;
            if (romanNumber.charAt(i) == 'V') arabicNumber += 5;
            if (romanNumber.charAt(i) == 'X') arabicNumber += 10;
            if (romanNumber.charAt(i) == 'L') arabicNumber += 50;
            if (romanNumber.charAt(i) == 'C') arabicNumber += 100;
            if (romanNumber.charAt(i) == 'D') arabicNumber += 500;
            if (romanNumber.charAt(i) == 'M') arabicNumber += 1000;
        }
        return arabicNumber;
    }
}
