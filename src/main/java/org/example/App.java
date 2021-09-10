package org.example;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Exercise 17 Solution
 *  Copyright 2021 Patrick Mac
 */

public class App
{
    private static final double male = 0.73;
    private static final double female = 0.66;
    static double Gender(int gender, double r)
    {
        if(gender == 1)
        {
            r = male;
        }
        else if(gender == 2)
        {
            r = female;
        }
        return r;
    }
    public static void main( String[] args ) {
        boolean flag;
        int n = 0;
        String stringGender;
        String stringOunce;
        String stringWeight;
        String stringHours;
        double r = 0;

        Scanner scan = new Scanner(System.in);
        do {
            do {
                System.out.print("Enter a 1 is you are male or a 2 if you are female: ");
                stringGender = scan.nextLine();
                try {
                    Integer.parseInt(stringGender);
                    flag = false;
                } catch (NumberFormatException e) {
                    System.out.println("Enter only numeric values");
                    flag = true;
                }

            } while (flag);
            if(stringGender.equals("1") || stringGender.equals("2"))
            {
                n = 1;
            }
            else
            {
                System.out.println("That number is not 1 or 2");
            }
        }while(n == 0);

        do {
            System.out.print("How many ounces of alcohol did you have? ");
            stringOunce = scan.nextLine();
            try {
                Double.parseDouble(stringOunce);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter only numeric values");
                flag = true;
            }

        } while (flag);


        do {
            System.out.print("What is your weight, in pounds? ");
            stringWeight = scan.nextLine();
            try {
                Double.parseDouble(stringWeight);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter only numeric values");
                flag = true;
            }

        } while (flag);


        do {
            System.out.print("How many hours has it been since your last drink? ");
            stringHours = scan.nextLine();
            try {
                Double.parseDouble(stringOunce);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter only numeric values");
                flag = true;
            }

        } while (flag);


        int gender = Integer.parseInt(stringGender);
        double ounce = Double.parseDouble(stringOunce);
        double weight = Double.parseDouble(stringWeight);
        double hours = Double.parseDouble(stringHours);

        double BAC = ((ounce * 5.14 / weight * Gender(gender,r)) - 0.015 * hours);


        System.out.println("Your BAC is "+String.format("%.6f",BAC));
        if(BAC >= 0.08)
        {
            System.out.println("It is not legal for you to drive.");
        }
        else if(BAC < 0.08)
        {
            System.out.println("It is legal for you to drive.");
        }

    }
}