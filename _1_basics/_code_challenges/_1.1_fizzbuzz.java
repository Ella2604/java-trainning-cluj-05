package com.codewithmush;

import java.lang.Math;


public class FizzBuzz {

    public static void main(String[] args) {

        int n = 0;

        for (int i = 1; i <= 100; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                n = i;
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                n = i;
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                n = i;
                System.out.println("Buzz");
            }


            if (i % 7 == 0) {
                n = i;
                System.out.println("Rizz");
            }


            if (i % 11 == 0) {
                n = i;
                System.out.println("Jazz");
            }

            if (n != i)

                System.out.println(i);
        }
    }
}