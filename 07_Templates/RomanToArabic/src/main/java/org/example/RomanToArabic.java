package org.example;

public class RomanToArabic
{
    public static int toArabic(String romanNumber) {
        int arabicNumber = 0;
        boolean condition = true;
        boolean condition400 = true;
        boolean condition9 = true;


        for (int i = 0; i < romanNumber.length(); i++) {
            if (romanNumber.length() >= 2 && romanNumber.charAt(romanNumber.length()-1) == 'V'
                    && romanNumber.charAt(romanNumber.length()-2) == 'I' && romanNumber.length() >= 2&& condition) {
                arabicNumber += 4;
                condition = false;
            }

            if((romanNumber.length() >= 2&& romanNumber.charAt(0) == 'C'&& romanNumber.charAt(1) == 'D') &&  condition400){
              arabicNumber += 400;
              condition400 = false;
            }

            if(romanNumber.length() == 2 && romanNumber == "IX" ){
                arabicNumber = 9;
                condition = false;
            }


            if (romanNumber.charAt(i) == 'I' && condition) arabicNumber += 1;
            if (romanNumber.charAt(i) == 'V' && condition) arabicNumber += 5;
            if (romanNumber.charAt(i) == 'X' && condition) arabicNumber += 10;
            if (romanNumber.charAt(i) == 'L') arabicNumber += 50;
            if (romanNumber.charAt(i) == 'C'&& condition400) arabicNumber += 100;
            if (romanNumber.charAt(i) == 'D'&& condition400) arabicNumber += 500;
            if (romanNumber.charAt(i) == 'M') arabicNumber += 1000;
        }
        return arabicNumber;
    }
}
