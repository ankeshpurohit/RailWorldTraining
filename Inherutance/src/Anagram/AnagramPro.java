package Anagram;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AnagramPro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String s = sc.nextLine();

        System.out.print("Enter the second string: ");
        String s1 = sc.nextLine();

        s=s.toLowerCase();
        s1=s1.toLowerCase();

        if (s.length() == s1.length()) {
            char[] charArray1 = s.toCharArray();
            char[] charArray2 = s1.toCharArray();

            boolean result = Arrays.equals(charArray1, charArray2);

            if (result) {
                System.out.println(s + " and " + s1 + " are anagrams.");
            } else {
                System.out.println(s + " and " + s1 + " are not anagrams.");
            }
        } else {
            System.out.println(s + " and " + s1 + " are not anagrams.");
        }


    }
}
