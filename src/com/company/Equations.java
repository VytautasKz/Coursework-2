package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

class Equations {
    static void solver() throws InterruptedException {
        Scanner slv = new Scanner(System.in);   //Create scanner
        String ans; //For checking if user wants to round
        System.out.println("Do you want to round the result? (current precision is set at: " + Main.p + ") Y/N");
        ans = slv.nextLine();   //read ans
        ans = ans.toLowerCase();    //make ans lowercase
        if (ans.equals("y") || ans.equals("n")) { //check if ans has a valid choice
            System.out.println("Equation format is ax + b = c");
            Thread.sleep(300);
            System.out.println("Enter the numbers as follows:");
            Thread.sleep(300);
            System.out.println("a - first number");
            try {
                //read numbers and calculate
                double a = slv.nextDouble();
                System.out.println("b - second number");
                double b = slv.nextDouble();
                System.out.println("c - third number");
                double c = slv.nextDouble();
                double sum = c - b;
                sum /= a;
                if (ans.equals("y")) {  //round result if ans was y
                    System.out.println("X = " + Main.decimalFormat.format(sum));
                } else {
                    System.out.println("X = " + sum);
                }
            } catch (InputMismatchException e) {
                System.out.println("Unrecognized input");
            }
        } else {
            System.out.println("Unrecognised solver input");
        }
        Main.menuText();
    }
}
