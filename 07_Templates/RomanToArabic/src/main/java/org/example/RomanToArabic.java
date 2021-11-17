package org.example;

public class RomanToArabic
{
    public static int toArabic(String romanNumber) {
        int arabicNumber = 0;
        boolean four = true;
        boolean one = true;
        boolean five = true;
        for (int i = 0; i < romanNumber.length(); i++) {
            if (romanNumber.length() >= 2 && romanNumber.charAt(romanNumber.length()-1) == 'V'
                    && romanNumber.charAt(romanNumber.length()-2) == 'I' && four) {
                arabicNumber += 4;
                one = false;
                five = false;
                four = false;
            }

            if (romanNumber.charAt(i) == 'I' && one) arabicNumber += 1;
            if (romanNumber.charAt(i) == 'V' && five) arabicNumber += 5;
            if (romanNumber.charAt(i) == 'X') arabicNumber += 10;
            if (romanNumber.charAt(i) == 'L') arabicNumber += 50;
            if (romanNumber.charAt(i) == 'C') arabicNumber += 100;
            if (romanNumber.charAt(i) == 'D') arabicNumber += 500;
            if (romanNumber.charAt(i) == 'M') arabicNumber += 1000;
        }
        return arabicNumber;
    }
}
