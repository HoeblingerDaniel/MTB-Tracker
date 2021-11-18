package org.example;

public class RomanToArabic
{
    public static int toArabic(String romanNumber) {
        int arabicNumber = 0;
        boolean condition4 = true;
        boolean condition40 = true;
        boolean condition400 = true;
        boolean condition9 = true;
        boolean condition90 = true;
        boolean condition900 = true;

        for (int i = 0; i < romanNumber.length(); i++) {
            if (index("IV", romanNumber)  != -1 && condition4) {
                arabicNumber += 4;
                condition4 = false;
            }
            if (index("IX", romanNumber)  != -1 && condition9) {
                arabicNumber += 9;
                condition9 = false;
            }
            if (index("XL", romanNumber)  != -1 && condition40) {
                arabicNumber += 40;
                condition40 = false;
            }
            if(index("XC", romanNumber) != -1  && condition90){
                arabicNumber += 90;
                condition90 = false;
            }
            if(index("CD", romanNumber)  != -1 &&  condition400){
              arabicNumber += 400;
              condition400 = false;
            }
            if (index("CM", romanNumber)  != -1 && condition900) {
                arabicNumber += 900;
                condition900 = false;
            }
            if (romanNumber.charAt(i) == 'I' && condition4 && condition9) arabicNumber += 1;
            if (romanNumber.charAt(i) == 'V' && condition4) arabicNumber += 5;
            if (romanNumber.charAt(i) == 'X' && condition9 && condition90 && condition40 ) arabicNumber += 10;
            if (romanNumber.charAt(i) == 'L'&& condition40) arabicNumber += 50;
            if (romanNumber.charAt(i) == 'C'&& condition400 && condition90 && condition900) arabicNumber += 100;
            if (romanNumber.charAt(i) == 'D'&& condition400 ) arabicNumber += 500;
            if (romanNumber.charAt(i) == 'M' && condition900) arabicNumber += 1000;
        }
        return arabicNumber;
    }

    public static int index(String s, String RomanNumber){
      for(int i = 0; i < RomanNumber.length() -1; i++){
          if(s.charAt(0) == RomanNumber.charAt(i) && s.charAt(1) == RomanNumber.charAt(i+1)){
              return i;
          }
      }
      return -1;
    }
}

